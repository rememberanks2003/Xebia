package yak.shop.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import yak.shop.exception.StockInvalidException;
import yak.shop.factory.LiveStockFactory;
import yak.shop.live.stock.ILiveStock;
import yak.shop.model.Herd;
import yak.shop.model.YakEntity;

public class YakShopApplication {

	public static void main(String[] args) {
		
		//Scanner to take file path and elapsed day input
		Scanner sc = new Scanner(System.in);
		
		//User command line interface to ask for path of XML
		System.out.println("Enter Input File Name (Absolute Path)");
		String fileName = sc.next();
		
		//User command line interface to ask for Elapsed Time in Days
		System.out.println("Enter Elapsed Time in Days");
		int elapsedTimeIndaysInput = sc.nextInt();
		//JaxB Context which will be used for parsing XML and gt the objects.
		try {
			List<YakEntity> list = parseXML(fileName);

			double milkLimt = 0;
			double woolLimt = 0;
			
			getFinalResult(elapsedTimeIndaysInput, list, milkLimt, woolLimt);

		} catch( JAXBException|StockInvalidException e) {
			e.printStackTrace();
		}
	}

	private static List<YakEntity> parseXML(String fileName) throws JAXBException {
		
		List<YakEntity> listofYaks = new ArrayList<YakEntity>();
		try {
			File xmlFile = new File(fileName);
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document doc = documentBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("labyak");
			for (int temp = 0; temp < nodeList.getLength(); temp++) {
				Node node = nodeList.item(temp);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element yakElement = (Element) node;
						YakEntity yakRead = new YakEntity();
						yakRead.setName(yakElement.getAttribute("name"));
						yakRead.setAge(Double.parseDouble(yakElement.getAttribute("age")));
						yakRead.setSex(yakElement.getAttribute("sex"));
						listofYaks.add(yakRead);
					 }
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listofYaks;

	}

	private static void getFinalResult(int elapsedTimeIndaysInput, List<YakEntity> list, double milkLimt,
			double woolLimt) throws StockInvalidException {
		ILiveStock<YakEntity> yakEntity = LiveStockFactory.getInstance(LiveStockFactory.STOCKTYPE.YAK.toString());
		//iterate through the the number of days to calculate the total number of milk an wool available
			for (YakEntity yak : list) {
				if ("f".equalsIgnoreCase(yak.getSex())) {
					milkLimt += yakEntity.calculateMilk(yak, elapsedTimeIndaysInput);
				}
				woolLimt += yakEntity.calculateWool(yak, elapsedTimeIndaysInput);
			}

		System.out.println("In Stock");
		System.out.println(milkLimt + " Liters of milk");
		System.out.println(woolLimt + " Skins of wool\n");
		yakEntity.calculateAge(list, elapsedTimeIndaysInput);
	}

	
}
