import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileOutputStream;


public class CreateXL {
    /** Excel 文件要存放的位置，假定在D盘下*/
    public static String outputFile = "D:\\蓝桥\\test.xls";
    public static void main(String argv[]) {
		String course [][] = {{"科目,成绩"},{"语文","90"},{"英语","88"},{"数学","99"}};
        try {
            // 创建新的Excel 工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 在Excel工作簿中建一工作表，其名为缺省值
            // 如要新建一名为"效益指标"的工作表，其语句为：
            HSSFSheet sheet = workbook.createSheet("学生成绩");
            // 在索引0的位置创建行（最顶端的行）
			for(int i = 0 ; i < course.length ; i++){
				HSSFRow row = sheet.createRow((short)i);
				for(int j = 0 ; j < course[i].length ; j++){
					HSSFCell cell = row.createCell((short)j);
					cell.setCellValue(course[i][j]);
				    }
				}
				/*
            cell01.setCellValue("科目");
			cell02.setCellValue("分数");

			  HSSFRow row01 = sheet.createRow((short)1);
            //在索引0的位置创建单元格（左上端）
            HSSFCell cell03 = row01.createCell((short)0);

			HSSFCell cell04 = row01.createCell((short)1);
            
            // 在单元格中输入一些内容
            cell03.setCellValue("语文");
			cell04.setCellValue("90");

			  HSSFRow row02 = sheet.createRow((short)2);
            //在索引0的位置创建单元格（左上端）
            HSSFCell cell05 = row02.createCell((short)0);

			HSSFCell cell06 = row02.createCell((short)1);
            
            // 在单元格中输入一些内容
            cell05.setCellValue("英语");
			cell06.setCellValue("88");
			*/
            // 新建一输出文件流
            FileOutputStream fOut = new FileOutputStream(outputFile);
            // 把相应的Excel 工作簿存盘
            workbook.write(fOut);
            fOut.flush();
            // 操作结束，关闭文件
            fOut.close();
            System.out.println("文件生成...");
        } catch (Exception e) {
            System.out.println("已运行 xlCreate() : " + e);
        }
    }
}