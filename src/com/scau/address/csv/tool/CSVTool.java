package com.scau.address.csv.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.scau.address.bean.AddressBean;
import com.scau.address.bean.AddressBeanTool;


/**
 * ��дCSV��ʽ�ļ��Ĺ�����
 * @author Administrator
 *
 */

public class CSVTool {
	/** ��ȡ��ϵ���ļ�(csv��ʽ),���ڵ���ʱ���� */
	public static List<AddressBean> importCsvFile(File file) {
		List<AddressBean> list = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			reader.readLine();// ������Ϣ�����ý���
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] item = line.split(",");// �Զ��ŷָ�ÿһ������
				AddressBean bean = AddressBeanTool.toBean(item);// ��װ�������ݵ�AddressBean����
				if (bean != null)
					list.add(bean);
			}
			reader.close();
			return list;
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/** ����ϵ����Ϣд���ļ�(csv��ʽ)�У����ڵ���ʱ���� */
	public static void exportCsvFile(List<AddressBean> list, File file) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write("����,��ͥ�绰,�ƶ��绰,�ʼ���ַ,����,������ַ,��ͥ��ַ,�ʱ�,��ϵ��,��ע");// �����У��������е���Ϣ
			writer.newLine();// ��������
			for (AddressBean bean : list) {
				writer.write(bean.getName()+",");
				writer.write(bean.getTelephone()+",");
				writer.write(bean.getMobilephone()+",");
				writer.write(bean.getEmail()+",");
				writer.write(bean.getBirthday()+",");
				writer.write(bean.getWorkplace()+",");
				writer.write(bean.getAddress()+",");
				writer.write(bean.getPostcode()+",");
				writer.write(bean.getGroup()+",");
				writer.write(bean.getRemarks());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void test() {
		/*���Ե���һ��csv�ļ�*/
		List<AddressBean> list = new ArrayList<>();
		AddressBean bean = new AddressBean();
		bean.setName("����");
		bean.setTelephone("0663-3133456");
		bean.setMobilephone("15819610734");
		bean.setEmail("chen@163.com");
		bean.setAddress(";;��ɽ·;����;�㶫;515555;�й�");
		bean.setWorkplace("�����й�");
		bean.setGroup("����");
		bean.setPostcode("515555");
		bean.setRemarks("���˰�");
		bean.setBirthday("2000-11-11");
		list.add(bean);
		File file = new File("D:/mypbook.csv");
		exportCsvFile(list, file);
	}
}