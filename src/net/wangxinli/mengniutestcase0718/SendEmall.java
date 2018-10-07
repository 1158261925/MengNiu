package net.wangxinli.mengniutestcase0718;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SendEmall {
		public static void sendMail(String flagResult) {
			// �����ʼ���Ϣ
			MailSenderInfo mailInfo = new MailSenderInfo();
			mailInfo.setMailServerHost("smtp.Winchannel.net");
			mailInfo.setMailServerPort("25");
			mailInfo.setValidate(true);
			mailInfo.setUserName("weiqian@winchannel.net");
			mailInfo.setPassword("!QAZ2wsx");
			mailInfo.setFromAddress("weiqian@winchannel.net");
			// ���������ռ��˵��ʼ�����
			String[] address = { "wangjinyu@winchannel.net","wangxinli@winchannel.net","zhouyuping@winchannel.net","weiqian@winchannel.net","wujian@winchannel.net","liuyu@winchannel.net","fangqisong@winchannel.net","baifan@winchannel.net","yangzhi@winchannel.net","qupengxiao@winchannel.net"};
			mailInfo.setToAddress(address);
			mailInfo.setSubject("��ţ������Ŀ��¼----->"+flagResult);

			// �ʼ�����
			File file = new File("E://testfan");
			File[] contextFiles = file.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					if (name.endsWith(".txt")) {
						return true;
					} else {
						return false;
					}
				}
			});
			// ��File����ת����List����
			List<File> fileList = new ArrayList<File>();
			for (File f : contextFiles) {
				fileList.add(f);
			}

			// ����Ҫ��List�ļ��������򣬻�ȡ���µ��ļ�
			Collections.sort(fileList, new Comparator<File>() {
				public int compare(File o1, File o2) {
					if (o1.isDirectory() && o2.isFile())
						return -1;
					if (o1.isFile() && o2.isDirectory())
						return 1;
					return o2.getName().compareTo(o1.getName());
				}
			});

			// ��ȡ���µ����ݣ����ж�ȡ��д�뵽һ���ַ����
			StringBuilder result = new StringBuilder();
			try {
				BufferedReader br = new BufferedReader(new FileReader(
						fileList.get(0)));// ����һ��BufferedReader������ȡ�ļ�
				String s = null;
				while ((s = br.readLine()) != null) {// ʹ��readLine������һ�ζ�һ��
					result.append(System.lineSeparator() + s);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String str = result.toString();
			mailInfo.setContent(str);
			
			// ����
			File[] enclosure = file.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					// System.out.println("dir:"+dir+",name:"+name);
					if (name.endsWith(".jpg") || name.endsWith(".png")) {
						return true;
					} else {
						return false;
					}
				}
			});
			String[] fileNames = new String[enclosure.length];
			for (int i = 0; i < enclosure.length; i++) {
				fileNames[i] = enclosure[i].getAbsolutePath();
			}
			mailInfo.setAttachFileNames(fileNames);
			SimpleMailSender.sendHtmlMail(mailInfo);
			for (String filePath : fileNames) {
				new File(filePath).delete();
			}
			System.out.println("�������");
		}
	}

