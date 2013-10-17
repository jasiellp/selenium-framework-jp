package com.util;

import java.awt.Color;
import java.util.List;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfWriter;

public class SeleniumUtil {

	private Font f; 
	private PdfWriter writer; 	
	private Image evid;
	private String comando;
	private PdfContentByte cb;
	private Document document; 
	private Image logovery; 
	
	public void setComando(String comando){
		 this.comando = comando;
	}
	
	public String getComando(){
		return comando;
	} 
	

	
	public void gerarPDF(List<java.awt.Image> evidence,
			String nomeCenario, String descricaoCenario, String exception,
			String navegador,String caminho,String tempoExecucao) throws java.io.IOException {

		this.document = new Document();

		if (exception == null) 
			exception = "Teste Realizado com Sucesso";

		
		try {

			this.writer = PdfWriter.getInstance(this.document, new java.io.FileOutputStream(caminho+nomeCenario+".pdf"));

			this.document.open();
			
			this.cb = this.writer.getDirectContent();
			
			this.logovery = Image.getInstance(SeleniumUtil.this.getClass().getResource("/com/image/very.png"));

			this.logovery.setAbsolutePosition(60, 770);

			this.cb.addImage(this.logovery, 230, 0, 0, 70, 347, 760);

			this.document.add(new Paragraph(""));

			for (int y = 0; y < 4; y++)
				this.document.add(Chunk.NEWLINE);

			this.document.add(new Paragraph(
							"                                             "
									+ "Relatório de Execução Selenium",
							new Font(Font.HELVETICA, Font.DEFAULTSIZE,
									Font.BOLDITALIC)));

			for (int i = 0; i < 23; i++) {
				
				if (i == 12) {
					this.document.add(new Paragraph("Resultado do Teste: "
							+ exception));
					this.document.add(new Paragraph("Tempo de Execução: "+tempoExecucao));
					this.document.add(Chunk.NEWLINE);
				}
				
				this.document.add(Chunk.NEWLINE);
			
			}

			this.document.add(new Paragraph("Navegador: "+navegador));
			this.document.add(new Paragraph("Cenario: " + nomeCenario));
			this.document.add(new Paragraph("Data: " + this.dataDeHoje() + ""));
			this.document.add(new Paragraph("Hora da Execução: " + this.horaDeHoje()));
			this.document.add(new Paragraph("Descrição: " + descricaoCenario));

			this.document.add(Chunk.NEXTPAGE);

			this.f = new Font();
			this.f.setColor(Color.WHITE);

			PdfPCell cell0 = new PdfPCell();
			cell0.setHorizontalAlignment(33);
			cell0.addElement(new Paragraph("Sequência", this.f));
			cell0.setBackgroundColor(new Color(0, 0, 153));
			cell0.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);

			PdfPCell cell1 = new PdfPCell();
			cell1.addElement(new Paragraph("Nome Teste", this.f));
			cell1.setBackgroundColor(new Color(0, 0, 153));
			cell1.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);

			PdfPCell cell2 = new PdfPCell();
			cell2.addElement(new Paragraph("Status", this.f));
			cell2.setBackgroundColor(new Color(0, 0, 153));
			cell2.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);

			PdfPCell cell3 = new PdfPCell();

			cell3.addElement(new Paragraph("Mensagem", this.f));
			cell3.setBackgroundColor(new Color(0, 0, 153));
			cell3.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);

			for (int i = 0; i < evidence.size(); i++) {

				this.document.add(Chunk.NEXTPAGE);
				this.logovery.setAbsolutePosition(409, 770);
				this.cb.addImage(this.logovery, 230, 0, 0, 70, 347, 760);

				for (int j = 0; j < 4; j++)
					this.document.add(Chunk.NEWLINE);

				this.evid = Image.getInstance(evidence.get(i), null);
				this.evid.setAbsolutePosition(70, 400);
				this.cb.addImage(this.evid, 450, 0, 0, 300, 70, 430);
			}

			} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		this.document.close();

	}
	
    private final String horaDeHoje(){
        return (new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date()).toString());
   }
    
    private final String dataDeHoje(){
        return (new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()).toString());
    }
    
}
