package template.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtil {
	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	private String s;

	public void writeToFile(@SuppressWarnings("rawtypes") ArrayList list) {
		String path = s;
		File file = new File(path);
		if (!file.exists()) {
			String str = null;
			try {
				file.createNewFile();
				FileWriter fw = new FileWriter(file);
				BufferedWriter bufw = new BufferedWriter(fw);
				for (int i = 0; i < list.size(); i++) {
					if ((str = (String) list.get(i)) != null) {
						bufw.write(str);
						bufw.newLine();
					}
				}
				bufw.close();
				fw.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			String str = null;
			try {
				FileWriter fw = new FileWriter(file);
				BufferedWriter bufw = new BufferedWriter(fw);
				for (int i = 0; i < list.size(); i++) {
					if ((str = (String) list.get(i)) != null) {
						bufw.write(str);
						bufw.newLine();
					}
				}
				bufw.close();
				fw.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<String> readFromFile() {
		File file = new File(s);
		String str = null;
		ArrayList<String> list = new ArrayList<String>();
		FileReader fr = null;
		if (file.exists()) {
			try {
				fr = new FileReader(file);
				BufferedReader bufr = new BufferedReader(fr);
				while ((str = bufr.readLine()) != null) {

					list.add(str);
				}
				bufr.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list = new ArrayList<String>();
		}
		return list;
	}

	public void append(String str) {
		String path = s;
		File file = new File(path);

		try {

			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bufw = new BufferedWriter(fw);

			bufw.write(str);
			bufw.newLine();

			bufw.close();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//读取文件的byte
	 public static byte[] getContent(String filePath) throws IOException {  
	        File file = new File(filePath);  
	        long fileSize = file.length();  
	        if (fileSize > Integer.MAX_VALUE) {  
	            System.out.println("file too big...");  
	            return null;  
	        }  
	        FileInputStream fi = new FileInputStream(file);  
	        byte[] buffer = new byte[(int) fileSize];  
	        int offset = 0;  
	        int numRead = 0;  
	        while (offset < buffer.length  
	        && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {  
	            offset += numRead;  
	        }  
	        // 确保所有数据均被读取  
	        if (offset != buffer.length) {  
	        throw new IOException("Could not completely read file "  
	                    + file.getName());  
	        }  
	        fi.close();  
	        return buffer;  
	    }  
		/**
		 * 将byte数组写入文件  
		 * @param path
		 * @param content
		 * @throws IOException
		 */
		public  static void createFile(String path, byte[] content) throws IOException {  

		      FileOutputStream fos = new FileOutputStream(path);  

		      fos.write(content);  
		      fos.close();  
		  }
		
		/**
		 * 根据文件路径删除文件，如果路径指向的文件不存在或删除失败则抛出异常。
		 * 
		 * @param path
		 * @return
		 * @throws Exception
		 */
		public static void deleteFile(String path) throws Exception {
			path = separatorReplace(path);
			File file = getFile(path);
			if (!file.delete()) {
				throw new Exception("delete file failure");
			}
		}

		/**
		 * 删除指定目录中指定前缀和后缀的文件。
		 * 
		 * @param dir
		 * @param prefix
		 * @param suffix
		 * @throws Exception
		 */
		public static void deleteFile(String dir, String prefix, String suffix)
				throws Exception {
			dir = separatorReplace(dir);
			File directory = getFolder(dir);
			File[] files = directory.listFiles();
			for (File file : files) {
				if (file.isFile()) {
					String fileName = file.getName();
					if (fileName.startsWith(prefix) && fileName.endsWith(suffix)) {
						deleteFile(file.getAbsolutePath());
					}
				}
			}
		}

		/**
		 * 根据路径删除文件夹，如果路径指向的目录不存在则抛出异常， 若存在则先遍历删除子项目后再删除文件夹本身。
		 * 
		 * @param path
		 * @throws Exception
		 */
		public static void deleteFolder(String path) throws Exception {
			path = separatorReplace(path);
			File folder = getFolder(path);
			File[] files = folder.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					deleteFolder(file.getAbsolutePath());
				} else if (file.isFile()) {
					deleteFile(file.getAbsolutePath());
				}
			}
			folder.delete();
		}
		/**
		 * 分隔符替换 window下测试通过
		 * 
		 * @param path
		 * @return
		 */
		public static String separatorReplace(String path) {
			return path.replace("\\", "/");
		}
		/**
		 * 通过路径获得文件夹， 若不存在则抛异常， 若存在则返回该文件夹。
		 * 
		 * @param path
		 * @return
		 * @throws FileNotFoundException
		 */
		public static File getFolder(String path) throws FileNotFoundException {
			path = separatorReplace(path);
			File folder = new File(path);
			if (!folder.isDirectory()) {
				throw new FileNotFoundException("folder not found!");
			}
			return folder;
		}
		/**
		 * 通过路径获得文件， 若不存在则抛异常， 若存在则返回该文件。
		 * 
		 * @param path
		 * @return
		 * @throws FileNotFoundException
		 */
		public static File getFile(String path) throws FileNotFoundException {
			path = separatorReplace(path);
			File file = new File(path);
			if (!file.isFile()) {
				throw new FileNotFoundException("file not found!");
			}
			return file;
		}
}
