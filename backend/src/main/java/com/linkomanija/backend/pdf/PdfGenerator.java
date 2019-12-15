package com.linkomanija.backend.pdf;

import com.itextpdf.text.DocumentException;
import com.linkomanija.backend.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;

import static com.itextpdf.text.pdf.BaseFont.EMBEDDED;
import static com.itextpdf.text.pdf.BaseFont.IDENTITY_H;

@Service
public class PdfGenerator {

  @Autowired
  private TemplateEngine engine;

  public void generateDocument(final Reservation reservation, final String type) throws IOException, DocumentException {
    final String html = renderHtml(reservation, type);

    final ITextRenderer renderer = new ITextRenderer();
    setHtmlLayout(renderer, html);

    final String fileDestination = getFileDestination(type);
    final OutputStream outputStream = new FileOutputStream(fileDestination);
    renderer.createPDF(outputStream);

    outputStream.close();
  }

  private String renderHtml(final Reservation reservation, final String type) throws UnsupportedEncodingException {
    final Context context = new Context();
    context.setVariable("reservation", reservation);
    String template = String.format("templates/%s/%s", type, type);
    final String renderedHtmlContent = engine.process(template, context);
    return convertToXhtml(renderedHtmlContent);
  }

  private static String convertToXhtml(final String html) throws UnsupportedEncodingException {
    final Tidy tidy = new Tidy();
    tidy.setQuiet(true);
    tidy.setInputEncoding(StandardCharsets.UTF_8.toString());
    tidy.setOutputEncoding(StandardCharsets.UTF_8.toString());
    tidy.setXHTML(true);
    final ByteArrayInputStream inputStream =
      new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    tidy.parseDOM(inputStream, outputStream);
    return outputStream.toString(StandardCharsets.UTF_8.toString());
  }

  private void setHtmlLayout(final ITextRenderer renderer, final String html)
    throws IOException, DocumentException {
    renderer.getFontResolver().addFont("templates/fonts/Arial.ttf", IDENTITY_H, EMBEDDED);
    renderer.getFontResolver().addFont("templates/fonts/Times New Roman.ttf", IDENTITY_H, EMBEDDED);

    final String baseUr1 =
      FileSystems.getDefault().getPath("src", "main", "resources").toUri().toURL().toString();
    renderer.setDocumentFromString(html, baseUr1);
    renderer.layout();
  }

  private String getFileDestination(String type) {
    String path = String.format("src/main/resources/templates/%s/%s.pdf", type, type);
    return new File(path).getAbsolutePath();
  }
}
