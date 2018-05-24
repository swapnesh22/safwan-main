package com.safwan.web.excelview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.safwan.data.model.Contract;

public class ContractExcelView extends AbstractXlsView {

	/*
	 * @Override - AbstractExcelView protected void buildExcelDocument(Map
	 * model, HSSFWorkbook workbook, HttpServletRequest request,
	 * HttpServletResponse response) throws Exception {
	 * 
	 * HSSFSheet excelSheet = workbook.createSheet("Contract List");
	 * setExcelHeader(excelSheet);
	 * 
	 * Set<Contract> cl = (Set<Contract>) model.get("contractList");
	 * List<Contract> contractList = new ArrayList<Contract>();
	 * contractList.addAll(cl); setExcelRows(excelSheet, contractList);
	 * 
	 * }
	 */

	/*
	 * public void setExcelHeader(HSSFSheet excelSheet) { HSSFRow excelHeader =
	 * excelSheet.createRow(0); excelHeader.createCell(0).setCellValue(
	 * "Contract Code"); excelHeader.createCell(1).setCellValue("Start Date");
	 * excelHeader.createCell(2).setCellValue("End Date");
	 * excelHeader.createCell(3).setCellValue("Frequency");
	 * excelHeader.createCell(4).setCellValue("Status"); }
	 * 
	 * public void setExcelRows(HSSFSheet excelSheet, List<Contract>
	 * contractList) { int record = 1; for (Contract contract : contractList) {
	 * HSSFRow excelRow = excelSheet.createRow(record++);
	 * excelRow.createCell(0).setCellValue(contract.getContractcode());
	 * excelRow.createCell(1).setCellValue(contract.getContractStartDate().
	 * toString());
	 * excelRow.createCell(2).setCellValue(contract.getContractEndDate().
	 * toString());
	 * excelRow.createCell(3).setCellValue(contract.getFrequency());
	 * excelRow.createCell(4).setCellValue(contract.getContractstatus()); } }
	 */

	public void setExcelHeader(Sheet excelSheet) {
		Row excelHeader = excelSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("Contract Code");
		excelHeader.createCell(1).setCellValue("Start Date");
		excelHeader.createCell(2).setCellValue("End Date");
		excelHeader.createCell(3).setCellValue("Frequency");
		excelHeader.createCell(4).setCellValue("Status");
	}

	public void setExcelRows(Sheet excelSheet, List<Contract> contractList) {
		int record = 1;
		for (Contract contract : contractList) {
			Row excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(contract.getContractcode());
			excelRow.createCell(1).setCellValue(contract.getContractStartDate().toString());
			excelRow.createCell(2).setCellValue(contract.getContractEndDate().toString());
			excelRow.createCell(3).setCellValue(contract.getFrequency());
			excelRow.createCell(4).setCellValue(contract.getContractstatus());
		}
	}

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * response.setHeader("Content-Disposition", "<span class="IL_AD" id="
		 * IL_AD4">attachment</span>;" + "<span class="IL_AD" id="
		 * IL_AD3">filename</span>=\"student.xls\"");
		 */

		Sheet sheet = workbook.createSheet("Contracts");
		setExcelHeader(sheet);

		@SuppressWarnings("unchecked")
		Set<Contract> cl = (Set<Contract>) model.get("contractList");
		List<Contract> contractList = new ArrayList<Contract>();
		contractList.addAll(cl);

		setExcelRows(sheet, contractList);

	}
}
