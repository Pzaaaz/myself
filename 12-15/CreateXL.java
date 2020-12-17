import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileOutputStream;


public class CreateXL {
    /** Excel �ļ�Ҫ��ŵ�λ�ã��ٶ���D����*/
    public static String outputFile = "D:\\����\\test.xls";
    public static void main(String argv[]) {
		String course [][] = {{"��Ŀ,�ɼ�"},{"����","90"},{"Ӣ��","88"},{"��ѧ","99"}};
        try {
            // �����µ�Excel ������
            HSSFWorkbook workbook = new HSSFWorkbook();
            // ��Excel�������н�һ����������Ϊȱʡֵ
            // ��Ҫ�½�һ��Ϊ"Ч��ָ��"�Ĺ����������Ϊ��
            HSSFSheet sheet = workbook.createSheet("ѧ���ɼ�");
            // ������0��λ�ô����У���˵��У�
			for(int i = 0 ; i < course.length ; i++){
				HSSFRow row = sheet.createRow((short)i);
				for(int j = 0 ; j < course[i].length ; j++){
					HSSFCell cell = row.createCell((short)j);
					cell.setCellValue(course[i][j]);
				    }
				}
				/*
            cell01.setCellValue("��Ŀ");
			cell02.setCellValue("����");

			  HSSFRow row01 = sheet.createRow((short)1);
            //������0��λ�ô�����Ԫ�����϶ˣ�
            HSSFCell cell03 = row01.createCell((short)0);

			HSSFCell cell04 = row01.createCell((short)1);
            
            // �ڵ�Ԫ��������һЩ����
            cell03.setCellValue("����");
			cell04.setCellValue("90");

			  HSSFRow row02 = sheet.createRow((short)2);
            //������0��λ�ô�����Ԫ�����϶ˣ�
            HSSFCell cell05 = row02.createCell((short)0);

			HSSFCell cell06 = row02.createCell((short)1);
            
            // �ڵ�Ԫ��������һЩ����
            cell05.setCellValue("Ӣ��");
			cell06.setCellValue("88");
			*/
            // �½�һ����ļ���
            FileOutputStream fOut = new FileOutputStream(outputFile);
            // ����Ӧ��Excel ����������
            workbook.write(fOut);
            fOut.flush();
            // �����������ر��ļ�
            fOut.close();
            System.out.println("�ļ�����...");
        } catch (Exception e) {
            System.out.println("������ xlCreate() : " + e);
        }
    }
}