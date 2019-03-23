package com.lin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

import com.alibaba.fastjson.JSON;
import com.lin.nettyserver.http.util.UrlUtil;

public class Test {

	public static void main(String[] args)  {
		String s="gmt_create=2019-01-05+20%3A37%3A33&charset=UTF-8&gmt_payment=2019-01-05+20%3A37%3A41&notify_time=2019-01-05+20%3A37%3A42&subject=%E8%AE%A2%E5%8D%9511546691847929&sign=mo4Z9Nb0csUWB7aQxysuX40Y05g2QHUnNn68Uib8VL0WikaFy1VT7LWvvyMSwfpcwp%2FBV3HnP2PuhcplPX7gXcjyd%2BeGuJSarxQn8v%2BVZQPZkA7UAjkY9mOPVevjN%2FPE89rv%2Fhxh7N%2BJaLu%2BN8TbiE1c7GDVOZFw8WODnSaEPxwxiOSKpfzZtThBXt7oRxmPTKyXfDLS%2BnNgxZQficUog6%2FDuSf4ZrnYdoXKz0BCJJCDQ8yioyZIjzWiYNPtAT2w2SmvBJgMGrHn%2BM7s5ZahRMfOHpIE1X9QVU1U0yVBJSVExYnB96yaj0nABWnneP8ySyCH5bFqgvyCYGDYUQj5Cw%3D%3D&buyer_id=2088102176976696&invoice_amount=200.00&version=1.0&notify_id=2f837de61c5f722067c1e2dec4cad7clbt&fund_bill_list=%5B%7B%22amount%22%3A%22200.00%22%2C%22fundChannel%22%3A%22ALIPAYACCOUNT%22%7D%5D&notify_type=trade_status_sync&out_trade_no=11546691847929&total_amount=200.00&trade_status=TRADE_SUCCESS&trade_no=2019010522001476690500753900&auth_app_id=2016092300580762&receipt_amount=200.00&point_amount=0.00&app_id=2016092300580762&buyer_pay_amount=200.00&sign_type=RSA2&seller_id=2088102176968710";
		System.out.println(JSON.toJSONString(UrlUtil.decodeParams(s, Charset.forName("utf-8"))));
	
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
