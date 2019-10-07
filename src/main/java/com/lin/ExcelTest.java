package com.lin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

import com.lin.util.EncryptUtil;
import com.lin.util.EncryptUtil.PasswordType;

public class ExcelTest {
	LoadData datas;

	public ExcelTest(String path) throws IOException {
		// TODO Auto-generated constructor stub
		Workbook workbook = null;
		if (path.toLowerCase().endsWith("xls")) {
			workbook = new HSSFWorkbook(Files.newInputStream(Paths.get(path)));
		} else {
			workbook = new XSSFWorkbook(Files.newInputStream(Paths.get(path)));
		}

		datas = loadFromExcel(workbook);

	}

	private LoadData loadFromExcel(Workbook workbook) {

		List<LoadData> loadDatas = new ArrayList<LoadData>();

		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			Map<String, List<PictureData>> picDatas = getSheetPictrues(workbook.getSheetAt(i), workbook);
			LoadData data = loadDataFromSingleSheet(workbook.getSheetAt(i), picDatas);
			loadDatas.add(data);

		}
		LoadData total = new LoadData();
		for (LoadData l : loadDatas) {
			total.addData.addAll(l.addData);
			total.modifyData.addAll(l.modifyData);
			total.deleteData.addAll(l.deleteData);
			total.newColumnData.addAll(l.newColumnData);
			total.newColumn.addAll(l.newColumn);
		}

		return total;
	}

	private LoadData loadDataFromSingleSheet(Sheet sheet, Map<String, List<PictureData>> picData) {

		LoadData data = new LoadData();
		List<String> heads = new ArrayList<String>();
		Row headRow = sheet.getRow(0);

		int verifyPosition = -1;
		int idPosition = -1;
		for (int i = 0; i < headRow.getPhysicalNumberOfCells(); i++) {
			heads.add(headRow.getCell(i).getStringCellValue());
			if ("id".equals(headRow.getCell(i).getStringCellValue())) {
				idPosition = i;
			}
			if ("verify".equals(headRow.getCell(i).getStringCellValue())) {
				verifyPosition = i;
			}

			if (verifyPosition != -1 && verifyPosition < i) {
				data.newColumn.add(headRow.getCell(i).getStringCellValue());
			}

		}

		boolean newDataSheet = false;
		if (verifyPosition == -1) {
			// if (verifyPosition == -1) {
			newDataSheet = true;
		}
		if (idPosition == -1 && verifyPosition >= 0) {
			return data;
		}

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			Map<String, ExcelDataValue> single = new HashMap<String, ExcelDataValue>();

			if (newDataSheet) {
				for (int j = 0; j < headRow.getPhysicalNumberOfCells(); j++) {
					if (j == idPosition)
						continue;

					single.put(heads.get(j), getCellValue(row.getCell(j), picData.get(i + "_" + j)));
				}

				data.addData.add(single);
			} else {
				for (int j = 0; j < verifyPosition; j++) {
					if (j == idPosition) {
						ExcelDataValue value = getCellValue(row.getCell(j), picData.get(i + "_" + j));
						if (!StringUtils.isBlank(value.strValue)) {
							single.put(heads.get(j), value);
						}
					} else {
						single.put(heads.get(j), getCellValue(row.getCell(j), picData.get(i + "_" + j)));
					}
				}

				if (StringUtils.isBlank(getCellValue(row.getCell(idPosition), null).strValue)) {
					for (int j = verifyPosition + 1; j < headRow.getPhysicalNumberOfCells(); j++) {
						single.put(heads.get(j), getCellValue(row.getCell(j), picData.get(i + "_" + j)));
					}
					data.addData.add(single);
				} else if (!StringUtils.isBlank(getCellValue(row.getCell(idPosition), null).strValue)
						&& StringUtils.isBlank(getCellValue(row.getCell(verifyPosition), null).strValue)) {
					data.deleteData.add(single);
				} else {
					StringBuilder sb = new StringBuilder();
					for (int j = 0; j < verifyPosition; j++) {
						sb.append(getCellValue(row.getCell(j), picData.get(i + "_" + j)));
					}
					String verifyStr = EncryptUtil.encodePass(sb.toString(), PasswordType.MD5);
					if (verifyStr.equals(getCellValue(row.getCell(verifyPosition), null))) {

					} else {
						data.modifyData.add(single);
					}

					Map<String, ExcelDataValue> columnChange = new HashMap<String, ExcelDataValue>();
					columnChange.put("id", getCellValue(row.getCell(idPosition), null));
					for (int j = verifyPosition + 1; j < headRow.getPhysicalNumberOfCells(); j++) {
						columnChange.put(heads.get(j), getCellValue(row.getCell(j), picData.get(i + "_" + j)));
					}
					data.newColumnData.add(columnChange);
				}
			}
		}

		return data;

	}

	public Map<String, List<PictureData>> getSheetPictrues(Sheet sheet, Workbook workbook) {
		if (workbook instanceof HSSFWorkbook) {
			return getSheetPictrues03((HSSFSheet) sheet, (HSSFWorkbook) workbook);
		} else if (workbook instanceof XSSFWorkbook) {
			return getSheetPictrues07((XSSFSheet) sheet, (XSSFWorkbook) workbook);
		}
		return null;
	}

	/**
	 * 获取Excel2003图片
	 * 
	 * @param sheetNum
	 *            当前sheet编号
	 * @param sheet
	 *            当前sheet对象
	 * @param workbook
	 *            工作簿对象
	 * @return Map key:图片单元格索引（0_1_1）String，value:图片流PictureData
	 * @throws IOException
	 */
	public Map<String, List<PictureData>> getSheetPictrues03(HSSFSheet sheet, HSSFWorkbook workbook) {

		Map<String, List<PictureData>> sheetIndexPicMap = new HashMap<String, List<PictureData>>();
		List<HSSFPictureData> pictures = workbook.getAllPictures();
		if (pictures.size() != 0) {
			for (HSSFShape shape : sheet.getDrawingPatriarch().getChildren()) {
				HSSFClientAnchor anchor = (HSSFClientAnchor) shape.getAnchor();
				if (shape instanceof HSSFPicture) {
					HSSFPicture pic = (HSSFPicture) shape;
					int pictureIndex = pic.getPictureIndex() - 1;
					HSSFPictureData picData = pictures.get(pictureIndex);
					String picIndex = String.valueOf(anchor.getRow1()) + "_" + String.valueOf(anchor.getCol1());
					List<PictureData> picList = null;
					if (sheetIndexPicMap.containsKey(picIndex)) {
						picList = sheetIndexPicMap.get(picIndex);
						picList.add(picData);
					} else {
						picList = new ArrayList<PictureData>();
						picList.add(picData);
						sheetIndexPicMap.put(picIndex, picList);
					}
				}
			}
			return sheetIndexPicMap;
		} else {
			return sheetIndexPicMap;
		}
	}

	/**
	 * 获取Excel2007图片
	 * 
	 * @param sheetNum
	 *            当前sheet编号
	 * @param sheet
	 *            当前sheet对象
	 * @param workbook
	 *            工作簿对象
	 * @return Map key:图片单元格索引（0_1_1）String，value:图片流PictureData
	 */
	public Map<String, List<PictureData>> getSheetPictrues07(XSSFSheet sheet, XSSFWorkbook workbook) {
		Map<String, List<PictureData>> sheetIndexPicMap = new HashMap<String, List<PictureData>>();

		for (POIXMLDocumentPart dr : sheet.getRelations()) {
			if (dr instanceof XSSFDrawing) {
				XSSFDrawing drawing = (XSSFDrawing) dr;
				List<XSSFShape> shapes = drawing.getShapes();
				for (XSSFShape shape : shapes) {
					XSSFPicture pic = (XSSFPicture) shape;
					XSSFClientAnchor anchor = pic.getPreferredSize();
					CTMarker ctMarker = anchor.getFrom();
					String picIndex = ctMarker.getRow() + "_" + ctMarker.getCol();
					List<PictureData> picList = null;
					if (sheetIndexPicMap.containsKey(picIndex)) {
						picList = sheetIndexPicMap.get(picIndex);
						picList.add(pic.getPictureData());
					} else {
						picList = new ArrayList<PictureData>();
						picList.add(pic.getPictureData());
						sheetIndexPicMap.put(picIndex, picList);
					}
				}
			}
		}

		return sheetIndexPicMap;
	}

	public static ExcelDataValue getCellValue(Cell cell, List<PictureData> list) {

		if (cell == null)
			return new ExcelDataValue("");

		if (cell instanceof XSSFCell) {
			return getCellValue07((XSSFCell) cell);
		} else if (cell instanceof HSSFCell) {
			return getCellValue03((HSSFCell) cell);
		}
		return new ExcelDataValue("");
	}

	public static ExcelDataValue getCellValue03(HSSFCell cell) {
		ExcelDataValue value = null;

		if (cell != null) {
			switch (cell.getCellType()) {
			case STRING:
				value = new ExcelDataValue(cell.getRichStringCellValue().getString());
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					value = new ExcelDataValue(String.valueOf(cell.getDateCellValue()));
				} else {
					value = new ExcelDataValue(String.valueOf(new BigDecimal(cell.getNumericCellValue())));
				}
				break;
			case BOOLEAN:
				value = new ExcelDataValue(String.valueOf(cell.getBooleanCellValue()));
				break;
			default:
				value = new ExcelDataValue("");
			}
			if (value.strValue.equals("null")) {
				value.strValue = "";
			}
			return value;

		} else {
			return new ExcelDataValue("");
		}

	}

	public static ExcelDataValue getCellValue07(XSSFCell cell) {
		ExcelDataValue value = null;

		if (cell != null) {
			switch (cell.getCellTypeEnum()) {
			case STRING:
				value = new ExcelDataValue(cell.getRichStringCellValue().getString());
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					value = new ExcelDataValue(String.valueOf(cell.getDateCellValue()));
				} else {
					value = new ExcelDataValue(String.valueOf((int)cell.getNumericCellValue()));
				}
				break;
			case BOOLEAN:
				value = new ExcelDataValue(String.valueOf(cell.getBooleanCellValue()));
				break;
			default:
				value = new ExcelDataValue("");
			}
			if (value.strValue.equals("null")) {
				value.strValue = "";
			}
			return value;

		} else {
			return new ExcelDataValue("");
		}

	}

	public static class LoadData {

		String tableName;
		List<Map<String, ExcelDataValue>> addData;
		List<Map<String, ExcelDataValue>> modifyData;
		List<Map<String, ExcelDataValue>> deleteData;
		List<Map<String, ExcelDataValue>> newColumnData;
		List<String> newColumn;
		Map<String, List<String>> repeatData;

		LoadData() {
			addData = new ArrayList<Map<String, ExcelDataValue>>();
			modifyData = new ArrayList<Map<String, ExcelDataValue>>();
			deleteData = new ArrayList<Map<String, ExcelDataValue>>();
			newColumnData = new ArrayList<Map<String, ExcelDataValue>>();

			newColumn = new ArrayList<String>();
			repeatData = new HashMap<String, List<String>>();
		}

		public String getTableName() {
			return tableName;
		}

		public void setTableName(String tableName) {
			this.tableName = tableName;
		}

		public List<Map<String, ExcelDataValue>> getAddData() {
			return addData;
		}

		public void setAddData(List<Map<String, ExcelDataValue>> addData) {
			this.addData = addData;
		}

		public List<Map<String, ExcelDataValue>> getModifyData() {
			return modifyData;
		}

		public void setModifyData(List<Map<String, ExcelDataValue>> modifyData) {
			this.modifyData = modifyData;
		}

		public List<Map<String, ExcelDataValue>> getDeleteData() {
			return deleteData;
		}

		public void setDeleteData(List<Map<String, ExcelDataValue>> deleteData) {
			this.deleteData = deleteData;
		}

		public List<Map<String, ExcelDataValue>> getNewColumnData() {
			return newColumnData;
		}

		public void setNewColumnData(List<Map<String, ExcelDataValue>> newColumnData) {
			this.newColumnData = newColumnData;
		}

		public List<String> getNewColumn() {
			return newColumn;
		}

		public void setNewColumn(List<String> newColumn) {
			this.newColumn = newColumn;
		}

		public Map<String, List<String>> getRepeatData() {
			return repeatData;
		}

		public void setRepeatData(Map<String, List<String>> repeatData) {
			this.repeatData = repeatData;
		}

	}

	public static class ExcelDataValue {
		String strValue;
		List<PicData> picValue;

		public ExcelDataValue() {
		}

		ExcelDataValue(String strValue) {
			this.strValue = strValue;
		}

		ExcelDataValue(List<PicData> picValue) {
			this.picValue = picValue;
		}

		public String getStrValue() {
			return strValue;
		}

		public void setStrValue(String strValue) {
			this.strValue = strValue;
		}

		public List<PicData> getPicValue() {
			return picValue;
		}

		public void setPicValue(List<PicData> picValue) {
			this.picValue = picValue;
		}

	}

	public static class PicData {
		byte[] bytes;
		String ext;

		public PicData() {
		}

		PicData(byte[] bytes, String ext) {
			this.bytes = bytes;
			this.ext = ext;
		}

		public byte[] getBytes() {
			return bytes;
		}

		public void setBytes(byte[] bytes) {
			this.bytes = bytes;
		}

		public String getExt() {
			return ext;
		}

		public void setExt(String ext) {
			this.ext = ext;
		}

	}

	public static void readFile(File f) throws IOException {
		if (f.isDirectory()) {
			File[] subFile = f.listFiles();
			for (File s : subFile) {
				readFile(s);
			}

		} else {
			readExcel(f);
		}

	}

	private static void readExcel(File f) throws IOException {
		Workbook workbook = null;
		try {
			// TODO Auto-generated method stub
			if (f.getPath().toLowerCase().endsWith("xls")) {
				workbook = new HSSFWorkbook(new FileInputStream(f));
			} else if (f.getPath().toLowerCase().endsWith("xlsx")) {
				workbook = new XSSFWorkbook(new FileInputStream(f));
			} else {
				System.out.println("not office xml " + f.getAbsolutePath());
				return;
			}

			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				List<ExcelDataValue> title = new ArrayList();
				Sheet sheet = workbook.getSheetAt(i);
				int columnCount = 0;
				int movePosition = 0;
				int headPosition = 0;

				int phonePosition = -1;
				int provincePosition = -1;

				while (columnCount == 0) {
					movePosition++;
					List<ExcelDataValue> tempHead = new ArrayList();
					Row r = sheet.getRow(sheet.getLastRowNum() - movePosition);
					for (int m = 0; m < r.getPhysicalNumberOfCells(); m++) {
						ExcelDataValue dv = getCellValue(r.getCell(m), null);
						if (!StringUtils.isBlank(dv.getStrValue()))
							tempHead.add(dv);
					}

					columnCount = tempHead.size();
				}
				for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {
					headPosition = j;
					if (sheet.getRow(j) == null)
						continue;

					List<ExcelDataValue> tempHead = new ArrayList();
					Row r = sheet.getRow(j);
					for (int m = 0; m < r.getPhysicalNumberOfCells(); m++) {
						ExcelDataValue dv = getCellValue(r.getCell(m), null);
						if (!StringUtils.isBlank(dv.getStrValue())) {
							tempHead.add(dv);

							if (isContain(needPhoneString, dv.getStrValue())) {
								phonePosition = m;
							}
							if (isContain(needProvince, dv.getStrValue())) {
								provincePosition = m;
							}

						}
					}
					if (tempHead.size() < columnCount) {

					} else {

						title.addAll(tempHead);
						break;
					}

				}

				if (provincePosition != -1 && phonePosition != -1 && title.size() >= columnCount) {
					for (int dataRow = headPosition + 1; dataRow < sheet.getPhysicalNumberOfRows(); dataRow++) {
						Row r = sheet.getRow(dataRow);
						String province = getCellValue(r.getCell(provincePosition), null).strValue;
						String phone = getCellValue(r.getCell(phonePosition), null).strValue;
						Set<String> set = null;
						province = province.replaceAll("省", "");
						if (map.containsKey(province)) {
							set = map.get(province);
							set.add(phone);
						} else {
							set = new HashSet<String>();
							set.add(phone);
							map.put(province, set);
						}

					}
				}

				if (title.size() < columnCount) {
					System.out.println("sheet.getLastRowNum()=" + sheet.getLastRowNum());
					System.out.println("columnCount=" + columnCount);
					System.out.println("headPosition=" + headPosition);
					System.out.println("title.size()=" + title.size());
					System.out.println("head problem " + f.getAbsolutePath());

					for (ExcelDataValue dv : title) {
						System.out.println(dv.getStrValue());
					}

					System.exit(0);
				}
				allTtiles.add(title);
			}

		} catch (NotOfficeXmlFileException ex) {
			System.out.println("not office xml " + f.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("file error in " + f.getAbsolutePath());
		} finally {
			if (workbook != null)
				workbook.close();
		}

	}

	public static boolean isContain(String[] ar, String key) {
		for (String s : ar) {
			if (s.equals(key))
				return true;
		}
		return false;

	}

	static HashMap<String, Set<String>> map = new HashMap<String, Set<String>>();
	static List<List<ExcelDataValue>> allTtiles = new ArrayList();
	static String[] needPhoneString = { "举报人号码", "举报号码", "主叫号码" };
	static String[] needProvince = { "举报人归属省", "举报号码归属省" };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("1".compareTo("2"));
		
	}

}
