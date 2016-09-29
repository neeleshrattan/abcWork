package com.trantor.Service;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.hssf.util.HSSFColor;

import com.trantor.model.ItemData;
import com.trantor.model.MomfileData;
import com.trantor.model.PointDiscuss;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class WriteDataInFile {
	private static final String[] titles = { "Doc ID :", "Trantor/MOM/Ver 1.1",
			"Date Released : 28/1/2016" };

	private static final String[] titles1 = { "Participants",
			"Offsite team and Onsite team", "Purpose",
			"Fry's Web-Team– To address the blockers,issues and release plan",
			"Venue", "Teleconf", "Prepared by", "Amit Kapoor, Preeti Khanna",
			"To", "Dhruv", "Attendance", "WebTeam1 and WebTeam2", "Absence", "" };

	private static final String[] titles2 = { "S.no", "Item",
			"By When - DD/MM/YYYY", "By Whom : Responsibility" };



	private static Row headerRow;
	private static Cell headerCell;
	private static Sheet sheet;



	

	public static void writedatatofile(MomfileData filedata) throws Exception {

		ArrayList<ItemData> itemDataArr = filedata.getItemData();
		ArrayList<PointDiscuss> pointDiscuss = filedata.getPontDiscuss();

		Workbook wb;
		int row_num = 0;

		wb = new XSSFWorkbook();

		Map<String, CellStyle> styles = createStyles(wb);
		sheet = wb.createSheet("MOM");
		PrintSetup printSetup = sheet.getPrintSetup();
		printSetup.setLandscape(true);
		sheet.setFitToPage(true);
		sheet.setHorizontallyCenter(true);

		InputStream inputStream = new FileInputStream(
				"/home/neelesh/workspaceTrys/MOM/WebContent/Logo/logo.png");
		// Get the contents of an InputStream as a byte[].
		byte[] bytes = IOUtils.toByteArray(inputStream);
		// Adds a picture to the workbook
		int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
		// close the input stream
		inputStream.close();
		// Returns an object that handles instantiating concrete classes
		CreationHelper helper = wb.getCreationHelper();
		// Creates the top-level drawing patriarch.
		Drawing drawing = sheet.createDrawingPatriarch();

		// Create an anchor that is attached to the worksheet
		ClientAnchor anchor = helper.createClientAnchor();

		// create an anchor with upper left cell _and_ bottom right cell
		anchor.setCol1(10); // Column K
		anchor.setRow1(0); // Row 1
		anchor.setCol2(12); // Column M
		anchor.setRow2(1); // Row 2
        System.out.println("**************************writing Data to .odt file********************************");
		// Creates a picture
        System.out.println("-------------creating Logo picture-------------------");
		
        drawing.createPicture(anchor, pictureIdx);

		// title row
		headerRow = sheet.createRow(row_num);
		headerRow.setHeightInPoints(40);
		headerCell = headerRow.createCell(0);
		headerCell.setCellValue("Minutes of Meeting");
		headerCell.setCellStyle(styles.get("title"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$L$1"));

		// header row
		row_num++;
		headerRow = sheet.createRow(row_num);
		headerRow.setHeightInPoints(20);

		for (int i = 0; i < titles.length; i++) {

			if (i == 0) {
				headerCell = headerRow.createCell(i);
				headerCell.setCellValue(titles[i]);
				headerCell.setCellStyle(styles.get("header"));
				sheet.addMergedRegion(CellRangeAddress.valueOf("$A$2:$B$2"));
			}
			if (i == 1) {
				headerCell = headerRow.createCell(2);
				headerCell.setCellValue(titles[i]);
				headerCell.setCellStyle(styles.get("header"));
				sheet.addMergedRegion(CellRangeAddress.valueOf("$C$2:$I$2"));
			}
			if (i == 2) {
				headerCell = headerRow.createCell(9);
				headerCell.setCellValue(titles[i]);
				headerCell.setCellStyle(styles.get("header"));
				sheet.addMergedRegion(CellRangeAddress.valueOf("$J$2:$L$2"));
			}
		}

		// sub titles row
		int num = 0;
		for (int i = 0; i < titles1.length; i++) {

			if (i % 2 == 0) {
				row_num++;
				headerRow = sheet.createRow(row_num);
				headerRow.setHeightInPoints(20);
				headerCell = headerRow.createCell(0);
				headerCell.setCellValue(titles1[i]);
				System.out.print(titles1[i] + "-----");
				headerCell.setCellStyle(styles.get("header"));
				num = row_num + 1;
				sheet.addMergedRegion(CellRangeAddress.valueOf("$A$" + num
						+ ":$B$" + num));
			} else {
				headerCell = headerRow.createCell(2);
				headerCell.setCellValue(titles1[i]);
				System.out.println(titles1[i]);
				headerCell.setCellStyle(styles.get("header"));
				sheet.addMergedRegion(CellRangeAddress.valueOf("$C$" + num
						+ ":$L$" + num));
			}

		}
		//-------------------Heading for point discussed------------------------------------
		row_num++;
		headerRow = sheet.createRow(row_num);
		headerRow.setHeightInPoints(20);
		headerCell = headerRow.createCell(0);
		headerCell.setCellStyle(styles.get("header"));
		num = row_num + 1;
		sheet.addMergedRegion(CellRangeAddress.valueOf("$A$" + num + ":$L$"
				+ num));

		row_num++;
		headerRow = sheet.createRow(row_num);
		headerRow.setHeightInPoints(20);
		headerCell = headerRow.createCell(0);
		headerCell.setCellValue("S.no.");
		headerCell.setCellStyle(styles.get("titleBackground"));
		num = row_num + 1;
		sheet.addMergedRegion(CellRangeAddress.valueOf("$A$" + num + ":$B$"
				+ num));
		headerCell = headerRow.createCell(2);
		headerCell.setCellValue("Points Discussed");
		headerCell.setCellStyle(styles.get("titlefontcenter"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$C$" + num + ":$L$"
				+ num));

		
		//-------------------writing data for point discussed------------------------------------
		
		System.out.println("**************************Point discussed********************************");
		
		for (PointDiscuss p : pointDiscuss) {
			row_num++;
			headerRow = sheet.createRow(row_num);
			// headerRow.setHeight((short)-1);
			headerRow.setHeightInPoints(40);
			headerCell = headerRow.createCell(0);
			headerCell.setCellValue(p.getsNo());
			System.out.print(p.getsNo() + "-----");

			headerCell.setCellStyle(styles.get("cell1"));
			num = row_num + 1;
			sheet.addMergedRegion(CellRangeAddress.valueOf("$A$" + num + ":$B$"
					+ num));

			headerCell = headerRow.createCell(2);
			headerCell.setCellValue(p.getPointDiscuss());
			System.out.println(p.getPointDiscuss());
			headerCell.setCellStyle(styles.get("cell"));

			sheet.addMergedRegion(CellRangeAddress.valueOf("$C$" + num + ":$L$"
					+ num));
		}
		//-------------------Blank row before item------------------------------------
		row_num++;
		headerRow = sheet.createRow(row_num);
		headerRow.setHeightInPoints(20);
		headerCell = headerRow.createCell(0);
		headerCell.setCellValue("");
		headerCell.setCellStyle(styles.get("titleBackground"));
		num = row_num + 1;
		sheet.addMergedRegion(CellRangeAddress.valueOf("$A$" + num + ":$L$"
				+ num));

		//-------------------writing Heading for item------------------------------------
		row_num++;
		headerRow = sheet.createRow(row_num);
		headerRow.setHeightInPoints(20);
		num = row_num + 1;

		headerCell = headerRow.createCell(0);

		headerCell.setCellValue(titles2[0]);
		headerCell.setCellStyle(styles.get("header"));

		headerCell = headerRow.createCell(1);

		headerCell.setCellValue(titles2[1]);
		headerCell.setCellStyle(styles.get("header"));

		sheet.addMergedRegion(CellRangeAddress.valueOf("$B$" + num + ":$F$"
				+ num));

		headerCell = headerRow.createCell(6);

		headerCell.setCellValue(titles2[2]);
		headerCell.setCellStyle(styles.get("header"));

		sheet.autoSizeColumn(6);

		headerCell = headerRow.createCell(7);

		headerCell.setCellValue(titles2[3]);
		headerCell.setCellStyle(styles.get("header"));

		sheet.addMergedRegion(CellRangeAddress.valueOf("$H$" + num + ":$L$"
				+ num));
		sheet.autoSizeColumn(11);

		
		//-------------------writing data for item------------------------------------
		System.out.println("**************************Items data********************************");
		
		
		for (ItemData item : itemDataArr) {
			row_num++;
			headerRow = sheet.createRow(row_num);
			headerRow.setHeightInPoints(20);
			num = row_num + 1;

			headerCell = headerRow.createCell(0);
			headerCell.setCellValue(item.getsNo());
			System.out.println(item.getsNo());
			headerCell.setCellStyle(styles.get("cell"));

			headerCell = headerRow.createCell(1);
			headerCell.setCellValue(item.getItem());
			System.out.println(item.getItem());
			headerCell.setCellStyle(styles.get("cell"));
			sheet.addMergedRegion(CellRangeAddress.valueOf("$B$" + num + ":$F$"
					+ num));

			headerCell = headerRow.createCell(6);
			headerCell.setCellValue(item.getByWhenDate());
			System.out.println(item.getByWhenDate());
			headerCell.setCellStyle(styles.get("cell"));
			sheet.autoSizeColumn(6);

			headerCell = headerRow.createCell(7);

			headerCell.setCellValue(item.getByWhome());
			System.out.println(item.getByWhome());
			headerCell.setCellStyle(styles.get("cell"));
			sheet.addMergedRegion(CellRangeAddress.valueOf("$H$" + num + ":$L$"
					+ num));
			sheet.autoSizeColumn(11);

		}

		row_num++;
		headerRow = sheet.createRow(row_num);
		headerRow.setHeightInPoints(40);
		headerCell = headerRow.createCell(0);
		headerCell.setCellValue("Note:");
		headerCell.setCellStyle(styles.get("bottumLine"));
		num = row_num + 1;
		// sheet.addMergedRegion(CellRangeAddress.valueOf("$A$"+num+":$A$"+num));

		headerCell = headerRow.createCell(1);
		headerCell
				.setCellValue("1. The MOM should be tracked and maintained on Weekly Basis based on client interactions in different sheets in one file. \n"
						+ "2. The sheet should be named as date of meeting/MOM release date.");
		headerCell.setCellStyle(styles.get("bottumLine"));
		headerRow.setHeightInPoints(40);
		sheet.addMergedRegion(CellRangeAddress.valueOf("$B$" + num + ":$L$"
				+ num));

		java.util.Date date = new java.util.Date();
		Timestamp ts = new Timestamp(date.getTime());

		// Write the output to a file
		String file = "/home/neelesh/MOM_FILE/MOM_" + ts + ".odt";
		/* if(wb instanceof XSSFWorkbook) file += "x"; */
		FileOutputStream out = new FileOutputStream(file);
		wb.write(out);
		out.close();
		System.out.println("*******************End of file writing*************************");

	}

	private static Map<String, CellStyle> createStyles(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
		CellStyle style = null;
		Font titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short) 12);
		titleFont.setBold(true);
		titleFont.setFontName("Calibri");
		style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		style.setFont(titleFont);
		styles.put("title", style);

		Font subtitle = wb.createFont();
		subtitle.setFontHeightInPoints((short) 11);
		subtitle.setBold(true);
		subtitle.setFontName("Calibri");

		style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);

		style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setFont(subtitle);
		style.setWrapText(true);
		styles.put("header", style);

		style = wb.createCellStyle();
		subtitle.setColor(IndexedColors.BLACK.getIndex());
		style.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		style.setBorderRight(XSSFCellStyle.BORDER_THICK);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(XSSFCellStyle.BORDER_THICK);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(XSSFCellStyle.BORDER_THICK);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(XSSFCellStyle.BORDER_THICK);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setFont(subtitle);
		style.setWrapText(true);
		style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
		style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		styles.put("titleBackground", style);

		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);

		styles.put("titlefontcenter", style);

		style = wb.createCellStyle();
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		style.setWrapText(true);
		Font cellesdata = wb.createFont();
		cellesdata.setFontHeightInPoints((short) 11);
		cellesdata.setFontName("Arial1");
		style.setFont(cellesdata);
		styles.put("cell", style);

		style = wb.createCellStyle();

		style.setWrapText(true);
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		Font cellesdataBold = wb.createFont();
		cellesdataBold.setFontHeightInPoints((short) 11);
		cellesdataBold.setFontName("Arial1");
		cellesdataBold.setBold(true);
		style.setFont(cellesdataBold);
		style.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		styles.put("cell1", style);

		style = wb.createCellStyle();
		XSSFFont bluefont = (XSSFFont) wb.createFont();
		bluefont.setColor(HSSFColor.LIGHT_BLUE.index);
		bluefont.setFontName("Arial1");
		bluefont.setItalic(true);
		style.setFont(bluefont);
		style.setAlignment(XSSFCellStyle.ALIGN_GENERAL);
		style.setBorderTop(XSSFCellStyle.BORDER_THICK);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		styles.put("bottumLine", style);

		return styles;
	}
}