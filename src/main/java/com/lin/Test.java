package com.lin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

public class Test {

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
	public static Map<String, PictureData> getSheetPictrues03(int sheetNum, HSSFSheet sheet, HSSFWorkbook workbook) {

		Map<String, PictureData> sheetIndexPicMap = new HashMap<String, PictureData>();
		List<HSSFPictureData> pictures = workbook.getAllPictures();
		if (pictures.size() != 0) {
			for (HSSFShape shape : sheet.getDrawingPatriarch().getChildren()) {
				HSSFClientAnchor anchor = (HSSFClientAnchor) shape.getAnchor();
				if (shape instanceof HSSFPicture) {
					HSSFPicture pic = (HSSFPicture) shape;
					int pictureIndex = pic.getPictureIndex() - 1;
					HSSFPictureData picData = pictures.get(pictureIndex);
					String picIndex = String.valueOf(sheetNum) + "_" + String.valueOf(anchor.getRow1()) + "_"
							+ String.valueOf(anchor.getCol1());
					sheetIndexPicMap.put(picIndex, picData);
				}
			}
			return sheetIndexPicMap;
		} else {
			return null;
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
	public static Map<String, PictureData> getSheetPictrues07(int sheetNum, XSSFSheet sheet, XSSFWorkbook workbook) {
		Map<String, PictureData> sheetIndexPicMap = new HashMap<String, PictureData>();

		for (POIXMLDocumentPart dr : sheet.getRelations()) {
			if (dr instanceof XSSFDrawing) {
				XSSFDrawing drawing = (XSSFDrawing) dr;
				List<XSSFShape> shapes = drawing.getShapes();
				for (XSSFShape shape : shapes) {
					XSSFPicture pic = (XSSFPicture) shape;
					XSSFClientAnchor anchor = pic.getPreferredSize();
					CTMarker ctMarker = anchor.getFrom();
					String picIndex = String.valueOf(sheetNum) + "_" + ctMarker.getRow() + "_" + ctMarker.getCol();
					sheetIndexPicMap.put(picIndex, pic.getPictureData());
				}
			}
		}

		return sheetIndexPicMap;
	}

	public static void printImg(List<Map<String, PictureData>> sheetList) throws IOException {

		for (Map<String, PictureData> map : sheetList) {
			Object key[] = map.keySet().toArray();
			for (int i = 0; i < map.size(); i++) {
				// 获取图片流
				PictureData pic = map.get(key[i]);
				// 获取图片索引
				String picName = key[i].toString();
				// 获取图片格式
				String ext = pic.suggestFileExtension();

				byte[] data = pic.getData();

				FileOutputStream out = new FileOutputStream("f:\\pic" + picName + "." + ext);
				out.write(data);
				out.close();
			}
		}

	}

	public static List<String> getClassNameByJar(String jarPath) throws IOException {
		List<String> myClassName = new ArrayList<String>();
		JarFile jarFile = null;
		try {
			jarFile = new JarFile(jarPath);
			Enumeration<JarEntry> entrys = jarFile.entries();
			while (entrys.hasMoreElements()) {
				JarEntry jarEntry = entrys.nextElement();
				String entryName = jarEntry.getName();
				if (entryName.endsWith(".class")) {
					entryName = entryName.replace("/", ".").substring(0, entryName.lastIndexOf("."));
					myClassName.add(entryName);
				}
			}
		} catch (Exception e) {
			// SystemLog.Log(LogType.systemInfo, e.getMessage(), e);
		} finally {
			if (jarFile != null) {
				jarFile.close();
			}
		}
		return myClassName;
	}
}
