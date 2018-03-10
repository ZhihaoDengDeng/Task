package com.scau.address.vcf.tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.scau.address.bean.AddressBean;

/**
 * ��дVCF��ʽ�ļ��Ĺ�����
 * @author Administrator
 *
 */

public class VCFTool {
	
	/** ����ϵ����Ϣд���ļ�(vcard��ʽ)�У����ڵ���ʱ���� */
	public static void exportVcfFile(List<AddressBean> list, File file) {
		try {
			if (file.exists()) {
				file.createNewFile();
			}
			BufferedWriter reader = new BufferedWriter(new PrintWriter(file));
			for (AddressBean bean : list) {
				/* ��ʼ��Ϣ�������ǩ */
				reader.write("BEGIN:VCARD");
				reader.write("\r\n");
				reader.write("VERSION:2.1");
				reader.write("\r\n");

				/* д������ */
				reader.write("FN:" + bean.getName());
				reader.write("\r\n");

				/* �绰���� */
				if (!bean.getTelephone().trim().isEmpty() || bean.getTelephone() != null)
					reader.write("TEL;WORK;VOICE:" + bean.getTelephone() + "\r\n");

				/* �ֻ����� */
				if (!bean.getMobilephone().trim().isEmpty() || bean.getMobilephone() != null)
					reader.write("TEL;CELL;VOICE:" + bean.getMobilephone() + "\r\n");

				/* �����ַ */
				if (!bean.getEmail().trim().isEmpty() || bean.getEmail() != null)
					reader.write("EMAIL;PREF;INTERNET:" + bean.getEmail() + "\r\n");

				/* ���� */
				if (!bean.getBirthday().trim().isEmpty() || bean.getBirthday() != null)
					reader.write("BDAY:" + bean.getBirthday() + "\r\n");

				/* ������λ */
				if (!bean.getWorkplace().trim().isEmpty() || bean.getWorkplace() != null)
					reader.write("ADR;WORK;POSTAL;PARCEL:" + bean.getWorkplace() + "\r\n");

				/* ��ͥסַ */
				if (!bean.getAddress().trim().isEmpty() || bean.getAddress() != null)
					reader.write("ADR;HOME;POSTAL;PARCEL:" + bean.getAddress() + "\r\n");

				/* �ʱ� */
				if (!bean.getPostcode().trim().isEmpty() || bean.getPostcode() != null)
					reader.write("X-PostCode:" + bean.getPostcode() + "\r\n");

				/* ������ */
				if (!bean.getGroup().trim().isEmpty() || bean.getGroup() != null)
					reader.write("X-Group:" + bean.getGroup() + "\r\n");

				/* ��ע */
				if (!bean.getRemarks().trim().isEmpty() || bean.getRemarks() != null)
					reader.write("NOTE;ENCODING=QUOTED-PRINTABLE:" + bean.getRemarks() + "\r\n");

				/* ������־ */
				reader.write("END:VCARD");
				reader.write("\r\n");
			}
			reader.flush();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*��ȡvcf��ʽ�ļ����������ݷ�װ��һ��List<AddressBean>��*/
	public List<AddressBean> importVCFFile(){
		return null;
	}
	
	/*���Է���*/
	@Test
	public void test() {
		
		/*���Ե���һ��vcf�ļ�*/
		List<AddressBean> list = new ArrayList<>();
		AddressBean bean = new AddressBean();
		bean.setName("����");
		bean.setTelephone("0663-3133456");
		bean.setMobilephone("15819610734");
		bean.setEmail("chen@163.com");
		bean.setAddress(";;��ɽ·;����;�㶫;515555;�й�");
		bean.setWorkplace("�����й�");
		bean.setGroup("����");
		bean.setPostcode("a");
		bean.setRemarks("e");
		bean.setBirthday("2000-11-11");
		list.add(bean);
		File file = new File("D:/mypbook.vcf");
	    exportVcfFile(list, file);
	    
	    
	}
}
