package com.lin.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import org.csource.common.MyException;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.lin.constants.BlockConstant;
import com.lin.constants.Result;
import com.lin.dao.DataTableDao;
import com.lin.request.req.AddNewTableReq;
import com.lin.request.req.AddTableDataReq;
import com.lin.request.req.ExecuteLoadExcelDataReq;
import com.lin.request.req.FindColumnsReq;
import com.lin.request.req.GetAvailableDataTableReq;
import com.lin.request.req.GetDataExcelReq;
import com.lin.request.req.GetModelExcelReq;
import com.lin.request.req.LoadDataFromExcelReq;
import com.lin.request.req.LoadDataReq;
import com.lin.request.req.UpdateDataTableReq;
import com.lin.request.resp.AddNewTableResp;
import com.lin.request.resp.AddTableDataResp;
import com.lin.request.resp.ExecuteLoadExcelDataResp;
import com.lin.request.resp.FindColumnsResp;
import com.lin.request.resp.GetAvailableDataTableResp;
import com.lin.request.resp.GetDataExcelResp;
import com.lin.request.resp.GetModelExcelResp;
import com.lin.request.resp.LoadDataFromExcelResp;
import com.lin.request.resp.LoadDataResp;
import com.lin.request.resp.UpdateDataTableResp;
import com.lin.service.DataService;
import com.lin.util.EncryptUtil;
import com.lin.util.EncryptUtil.PasswordType;
import com.lin.util.FileManager;
import com.lin.util.RedisManager;

@Configuration("http.properties")
@Service
@Transactional
public class DataServiceImpl implements DataService {

	@Autowired
	DataTableDao dataTableDao;

	@Autowired
	FileManager manager;

	@Autowired
	RedisManager redis;

	@Value("${fdfs.http}")
	String fdfsPath;

	DateFormat foramt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public void getAvailableDataTable(GetAvailableDataTableReq req, GetAvailableDataTableResp resp) {
		// TODO Auto-generated method stub
		resp.setList(dataTableDao.getAvailableDataTable());
	}

	@Override
	public void updateDataTable(UpdateDataTableReq req, UpdateDataTableResp resp) {
		// TODO Auto-generated method stub
		String reciveFile = req.getFile();
		try {
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(reciveFile));
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				Sheet sh = wb.getSheetAt(i);

				boolean isOK = checkFormat(sh);
				if (!isOK)
					continue;

				// 批量对比和修改
				// 二分法

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setResult(-1);
		}

	}

	private boolean checkFormat(Sheet sh) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addNewTable(AddNewTableReq req, AddNewTableResp resp) {
		// TODO Auto-generated method stub
		dataTableDao.addNewTable(req.getId(), req.getTableName(), req.getColumns());
	}

	@Override
	public void findColumnByTableName(FindColumnsReq req, FindColumnsResp resp) {
		// TODO Auto-generated method stub
		resp.setColumns(dataTableDao.findColumns(req.getName()));

	}

	@Override
	public void loadData(LoadDataReq req, LoadDataResp resp) {
		// TODO Auto-generated method stub
		resp.setColumns(dataTableDao.findColumns(req.getTableName()));
		resp.setDatas(dataTableDao.findData(req.getTableName(), req.getPage(), req.getPageSize(), req.getQuery()));

	}

	@Override
	public void addTableData(AddTableDataReq req, AddTableDataResp resp) {
		// TODO Auto-generated method stub
		resp.setReturnId(dataTableDao.addTableData(req.getTableName(), req.getObj()));
	}

	@Override
	public void getDataExcel(GetDataExcelReq req, GetDataExcelResp resp) {
		// TODO Auto-generated method stub
		Workbook workbook = new HSSFWorkbook();
		List<String> columns = dataTableDao.findColumns(req.getTableName());
		Sheet sheet = workbook.createSheet();
		Row row = sheet.createRow(0);
		for (int i = 0; i < columns.size(); i++) {
			row.createCell(i).setCellValue(columns.get(i));
		}
		row.createCell(columns.size()).setCellValue("verify");

		List<Map<String, Object>> list = dataTableDao.findData(req.getTableName(), 1, 1000, req.getParam());
		for (int j = 0; j < list.size(); j++) {
			Map<String, Object> ob = list.get(j);
			StringBuilder sb = new StringBuilder();
			Row newRow = sheet.createRow(j + 1);
			for (int i = 0; i < columns.size(); i++) {
				newRow.createCell(i).setCellValue(String.valueOf(ob.get(columns.get(i))));
				sb.append(String.valueOf(ob.get(columns.get(i))));
			}
			String verifyStr = EncryptUtil.encodePass(sb.toString(), PasswordType.MD5);
			newRow.createCell(columns.size()).setCellValue(verifyStr);
		}

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			workbook.write(os);
			workbook.close();
			os.flush();
			byte[] fileBytes = os.toByteArray();
			os.close();
			String[] ss = manager.upload_file(fileBytes, "xls", null);
			resp.setHttpPath(fdfsPath);
			resp.setGroupName(ss[0]);
			resp.setPath(ss[1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void loadDataFromExcel(LoadDataFromExcelReq req, LoadDataFromExcelResp resp) {
		// TODO Auto-generated method stub
		byte[] bytes;
		Workbook workbook = null;

		try {
			bytes = manager.download_file(req.getGroupName(), req.getExcelPath());
			ByteArrayInputStream steam = new ByteArrayInputStream(bytes);

			if (req.getExcelPath().toLowerCase().endsWith("xls")) {
				workbook = new HSSFWorkbook(steam);
			} else {
				workbook = new XSSFWorkbook(steam);
			}

			LoadData[] datas = loadFromExcel(req.getTableName(), workbook);

			resp.setAddDataCount(datas[0].addData.size());
			resp.setModifyDataCount(datas[0].modifyData.size());
			resp.setDeleteDataCount(datas[0].deleteData.size());
			resp.setNewColumns(datas[0].newColumn);
			resp.setProblemData(datas[1]);
			resp.setSequenceId(saveToSequence(datas[0]));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setResult(Result.ERROR_SYSTEM);
			resp.setMsg("EXCEL文件内容或者格式错误");
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void getModelExcel(GetModelExcelReq req, GetModelExcelResp resp) {
		// TODO Auto-generated method stub
		Workbook workbook = new HSSFWorkbook();
		List<String> columns = dataTableDao.findColumns(req.getTableName());
		Sheet sheet = workbook.createSheet();
		Row row = sheet.createRow(0);
		for (int i = 0; i < columns.size(); i++) {
			row.createCell(i).setCellValue(columns.get(i));
		}

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			workbook.write(os);

			workbook.close();
			os.flush();
			byte[] fileBytes = os.toByteArray();
			os.close();
			String[] ss = manager.upload_file(fileBytes, "xls", null);
			resp.setHttpPath(fdfsPath);
			resp.setGroupName(ss[0]);
			resp.setPath(ss[1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Long saveToSequence(LoadData loadData) {
		// TODO Auto-generated method stub
		Long sequenceId = redis.incr(BlockConstant.REDIS_SEQUENCE);
		redis.setex(sequenceId.toString().getBytes(), 30 * 60, JSON.toJSONString(loadData).getBytes());
		return sequenceId;
	}

	private LoadData loadFromSequence(Long sequenceId) {

		// TODO Auto-generated method stub

		String s = new String(redis.get(sequenceId.toString().getBytes()));
		redis.del(sequenceId.toString().getBytes());

		return JSON.toJavaObject(JSON.parseObject(s), LoadData.class);
	}

	@Override
	public void executeLoadExcelData(ExecuteLoadExcelDataReq req, ExecuteLoadExcelDataResp resp) {
		// TODO Auto-generated method stub
		LoadData datas = loadFromSequence(req.getSequenceId());
		for (Map<String, ExcelDataValue> map : datas.addData) {
			Map<String, String> transferMap = transferImgToStr(map);
			dataTableDao.addTableData(datas.tableName, transferMap);
		}

		for (Map<String, ExcelDataValue> map : datas.modifyData) {
			Map<String, String> transferMap = transferImgToStr(map);
			dataTableDao.updateTableData(datas.tableName, transferMap);
		}

		for (Map<String, ExcelDataValue> map : datas.deleteData) {
			Map<String, String> transferMap = transferImgToStr(map);
			dataTableDao.deleteTableData(datas.tableName, transferMap);
		}
	}

	private Map<String, String> transferImgToStr(Map<String, ExcelDataValue> map) {
		// TODO Auto-generated method stub
		Map<String, String> transferMap = new HashMap<String, String>();
		for (Entry<String, ExcelDataValue> entry : map.entrySet()) {
			ExcelDataValue value = entry.getValue();

			if (!StringUtils.isBlank(value.strValue)) {
				transferMap.put(entry.getKey(), value.strValue);
			} else if (value.picValue != null && value.picValue.size() > 0) {
				List<PicData> picData = value.picValue;
				StringBuilder sb = new StringBuilder();
				for (PicData pic : picData) {
					String[] path;

					try {
						path = manager.upload_file(pic.getBytes(), pic.getExt(), null);
						sb.append(fdfsPath + path[0] + "/" + path[1] + ",");
					} catch (IOException | MyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				sb.setLength(sb.length() - 1);
				transferMap.put(entry.getKey(), sb.toString());
			} else {
				transferMap.put(entry.getKey(), null);
			}
		}
		return transferMap;
	}

	private LoadData[] loadFromExcel(String tableName, Workbook workbook) {

		List<LoadData> loadDatas = new ArrayList<LoadData>();

		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			Map<String, List<PictureData>> picDatas = getSheetPictrues(workbook.getSheetAt(i), workbook);
			LoadData data = loadDataFromSingleSheet(workbook.getSheetAt(i), picDatas);
			loadDatas.add(data);

		}
		LoadData total = new LoadData();
		total.tableName = tableName;
		for (LoadData l : loadDatas) {
			total.addData.addAll(l.addData);
			total.modifyData.addAll(l.modifyData);
			total.deleteData.addAll(l.deleteData);
			total.newColumnData.addAll(l.newColumnData);
			total.newColumn.addAll(l.newColumn);
		}

		LoadData repeatData = checkData(total);
		LoadData[] result = { total, repeatData };
		return result;
	}

	private LoadData checkData(LoadData total) {
		// TODO Auto-generated method stub

		// 全部查重
		String[] checkKey = { "id" };
		LoadData repeats = new LoadData();
		repeats.addData = checkSingleListRepeat(total.addData, null);
		repeats.modifyData = checkSingleListRepeat(total.modifyData, checkKey);
		repeats.deleteData = checkSingleListRepeat(total.deleteData, checkKey);

		// 检查modify和delete是否重复
		// 检查newcolumn和delete是否重复

		repeats.repeatData.put("modify&delete", checkMutipleListRepeat(checkKey, total.modifyData, total.deleteData));
		return repeats;
	}

	private List<String> checkMutipleListRepeat(String[] checkKey, List<Map<String, ExcelDataValue>>... checkList) {
		List<String> repeatList = new ArrayList<String>();

		List<Set> totalSet = new ArrayList<Set>();
		for (List<Map<String, ExcelDataValue>> list : checkList) {
			TreeSet<String> set = new TreeSet<String>();
			for (Map<String, ExcelDataValue> map : list) {
				Map<String, String> repeatCheckMap = new HashMap<String, String>();

				if (checkKey == null || checkKey.length == 0) {
					for (String key : map.keySet()) {
						repeatCheckMap.put(key, map.get(key).strValue);
					}
				} else {
					for (String key : checkKey) {
						repeatCheckMap.put(key, map.get(key).strValue);
					}
				}
				String str = JSON.toJSONString(repeatCheckMap);
				set.add(str);
			}
			totalSet.add(set);
		}

		Set<String> set2 = new HashSet<String>();
		for (int i = 0; i < totalSet.size(); i++) {
			for (int j = i + 1; j < totalSet.size(); j++) {
				set2.addAll(totalSet.get(i));
				set2.retainAll(totalSet.get(j));
				if (set2.size() > 0) {
					repeatList.addAll(set2);
				}
				set2.clear();
			}
		}

		return repeatList;
	}

	private List<Map<String, ExcelDataValue>> checkSingleListRepeat(List<Map<String, ExcelDataValue>> checkList,
			String[] checkKey) {
		List<Map<String, ExcelDataValue>> repeatList = new ArrayList<Map<String, ExcelDataValue>>();
		TreeSet<String> set = new TreeSet<String>();
		for (Map<String, ExcelDataValue> map : checkList) {

			Map<String, String> repeatCheckMap = new HashMap();
			if (checkKey == null || checkKey.length == 0) {

				for (String key : map.keySet()) {
					if (map.get(key) != null)
						repeatCheckMap.put(key, map.get(key).strValue);
				}
			} else {
				for (String key : checkKey) {
					if (map.get(key).strValue != null)
						repeatCheckMap.put(key, map.get(key).strValue);
				}
			}

			String str = JSON.toJSONString(repeatCheckMap);
			if (set.contains(str)) {
				repeatList.add(map);
			} else {
				set.add(str);
			}
		}
		return repeatList;
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
	 * @param sheetNum 当前sheet编号
	 * @param sheet    当前sheet对象
	 * @param workbook 工作簿对象
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
	 * @param sheetNum 当前sheet编号
	 * @param sheet    当前sheet对象
	 * @param workbook 工作簿对象
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

	private ExcelDataValue getCellValue(Cell cell, List<PictureData> list) {
		if (list != null && list.size() > 0) {

			List<PicData> pics = new ArrayList<PicData>();
			for (PictureData pic : list) {
				PicData p = new PicData(pic.getData(), pic.suggestFileExtension());
				pics.add(p);
			}

			return new ExcelDataValue(pics);
		}

		if (cell == null)
			return new ExcelDataValue("");

		if (cell instanceof XSSFCell) {
			return getCellValue07((XSSFCell) cell, list);
		} else if (cell instanceof HSSFCell) {
			return getCellValue03((HSSFCell) cell, list);
		}
		return new ExcelDataValue("");
	}

	private ExcelDataValue getCellValue03(HSSFCell cell, List<PictureData> list) {
		ExcelDataValue value = null;

		if (cell != null) {
			switch (cell.getCellType()) {
			case STRING:
				value = new ExcelDataValue(cell.getRichStringCellValue().getString());
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					value = new ExcelDataValue(foramt.format((cell.getDateCellValue())));
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
			byte[] bs = value.strValue.getBytes();
			for (byte b : bs) {
				System.out.print(b);
				System.out.print(" ");
			}
			System.out.println();
			System.out.println(value.strValue);

			return value;

		} else {
			return new ExcelDataValue("");
		}

	}

	private ExcelDataValue getCellValue07(XSSFCell cell, List<PictureData> list) {
		ExcelDataValue value = null;

		if (cell != null) {
			switch (cell.getCellTypeEnum()) {
			case STRING:
				value = new ExcelDataValue(cell.getRichStringCellValue().getString());
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					value = new ExcelDataValue(foramt.format(cell.getDateCellValue()));
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
			byte[] bs = value.strValue.getBytes();
			for (byte b : bs) {
				System.out.print(b);
				System.out.print(" ");
			}
			System.out.println();
			System.out.println(value.strValue);

			return value;

		} else {
			return new ExcelDataValue("");
		}

	}

	public byte[] generateExcel(String sheetName, List<String> heads, List<Map<String, String>> data) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		Sheet sheet = null;
		if (StringUtils.isBlank(sheetName)) {
			sheet = workbook.createSheet();
		} else {
			sheet = workbook.createSheet(sheetName);
		}

		Row row = sheet.createRow(0);

		for (int i = 0; i < heads.size(); i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(heads.get(i));
		}

		Cell verify = row.createCell(heads.size());
		verify.setCellValue("verify");

		for (int i = 1; i <= data.size(); i++) {
			Row dataRow = sheet.createRow(i);
			Map<String, String> obj = data.get(i - 1);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < heads.size(); j++) {
				dataRow.createCell(j).setCellValue(obj.get(heads.get(j)));
				sb.append(obj.get(heads.get(j)));
			}
			String verifyString = EncryptUtil.encodePass(sb.toString(), PasswordType.MD5);
			dataRow.createCell(heads.size()).setCellValue(verifyString);
		}

		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			workbook.write(os);
			workbook.close();
			os.flush();
			byte[] fileBytes = os.toByteArray();
			os.close();
			// Files.write(fileBytes, new File("f:\\123.xls"));

			return fileBytes;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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

}
