package intu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.inter.IFrame;

class Test157 implements IFrame{
	
	private static Thread thread;
	private static Process exec;
	private static BufferedWriter writer;
	private static File file;
	
	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws IOException, InterruptedException {
		thread = new Thread(threads);
		thread.start();
		
}
	public static void Grava(File arquivo, String itemPesquisado) throws IOException 
	 {
	  
        
       writer = new BufferedWriter(new FileWriter(arquivo));
       StringBuffer stb = new StringBuffer();
       stb.append("Dir\\").append(itemPesquisado).append(" /a /s /b");
       writer.write(stb.toString());
	   writer.close();
		 
	}
	
	
	private static Thread threads = new Thread(new Runnable() {

		
		public void run() {
			
			try {
			
				new File( "properties\\");
				file = File.createTempFile("ATempFile", ".bat");
				
				
				Grava(new File(file.getAbsolutePath()),"oijojpnioub.ohbuhb");
			
				exec = Runtime.getRuntime().exec(file.getAbsolutePath());
	  
				BufferedReader cmdStreamReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
				
				String cmdOutput ;
			
				int i = 0;
			
				while ((cmdOutput = cmdStreamReader.readLine()) != null) 
				{ 
					i++;
		            System.out.println((" "+i+ "ª "+cmdOutput+" \n"));
				}  
				
				file.delete(); 
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
			
		}
		
	});
	
	
	}