

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler
{
    //List to Hold GenBankEntry objects
    private List<GenBankEntry> gbList = null;
    private GenBankEntry gb = null;
    private StringBuilder data = null;

    //Getter method for GB List
    public List<GenBankEntry> getGbList()
    {
        return gbList;
    }

    boolean bAccession = false;
    boolean bLocus = false;
    boolean bTitle = false;
    boolean bSpecies = false;
    boolean bDateCreate = false;
    boolean bSeqLength = false;
    boolean bSequence = false;
    boolean bArticle_1 = false;
    boolean bArticle_2 = false;
    boolean bArticle_3 = false;
    boolean bArticle_4 = false;
    boolean bArticle_5 = false;
    boolean bDoi_1 = false;
    boolean bDoi_2 = false;
    boolean bDoi_3 = false;
    boolean bDoi_4 = false;
    boolean bDoi_5 = false;
    boolean bCountry = false;
    boolean bCountry_value = false;
    boolean bIsolation = false;
    boolean bIsolation_value = false;
    boolean bIsolate = false;
    boolean bIsolate_value = false;


    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("INSDSeq")) {

            gb = new GenBankEntry();
            if (gbList == null)
                gbList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("INSDSeq_locus")) {
            bLocus = true;
        } else if (qName.equalsIgnoreCase("INSDSeq_length")) {
            bSeqLength = true;
        } else if (qName.equalsIgnoreCase("INSDSeq_create-date")) {
            bDateCreate = true;
        } else if (qName.equalsIgnoreCase("INSDSeq_definition")) {
            bTitle = true;
        } else if (qName.equalsIgnoreCase("INSDSeq_primary-accession")) {
            bAccession = true;
        } else if (qName.equalsIgnoreCase("INSDSeq_organism")) {
            bSpecies = true;
        } else if (qName.equalsIgnoreCase("INSDSeq_sequence")) {
            bSequence = true;
        } else if (qName.equalsIgnoreCase("INSDReference_title") && !bArticle_1) {
            bArticle_1 = true;
        } else if (qName.equalsIgnoreCase("INSDReference_title") && bArticle_1) {
            bArticle_2 = true;
        } else if (qName.equalsIgnoreCase("INSDReference_title") && bArticle_2) {
            bArticle_3 = true;
        } else if (qName.equalsIgnoreCase("INSDReference_title") && bArticle_3) {
            bArticle_4 = true;
        } else if (qName.equalsIgnoreCase("INSDReference_title") && bArticle_4) {
            bArticle_5 = true;
        } else if (qName.equalsIgnoreCase("INSDXref_id") && !bDoi_1) {
            bDoi_1 = true;
        } else if (qName.equalsIgnoreCase("INSDXref_id") && bDoi_1) {
            bDoi_2 = true;
        } else if (qName.equalsIgnoreCase("INSDXref_id") && bDoi_2) {
            bDoi_3 = true;
        } else if (qName.equalsIgnoreCase("INSDXref_id") && bDoi_3) {
            bDoi_4 = true;
        } else if (qName.equalsIgnoreCase("INSDXref_id") && bDoi_4) {
            bDoi_5 = true;
        } else if (qName.equalsIgnoreCase("INSDQualifier_country")) {
            bCountry = true;
        } else if (qName.equalsIgnoreCase("INSDQualifier_value") && bCountry) {
            bCountry_value = true;
        } else if (qName.equalsIgnoreCase("INSDQualifier_isolation")) {
            bIsolation = true;
        } else if (qName.equalsIgnoreCase("INSDQualifier_value") && bIsolation) {
            bIsolation_value = true;
        } else if (qName.equalsIgnoreCase("INSDQualifier_isolate")) {
            bIsolate = true;
        } else if (qName.equalsIgnoreCase("INSDQualifier_value") && bIsolate) {
            bIsolate_value = true;
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        if (bLocus)
        {
            gb.setLocus(data.toString());
            bLocus = false;
        } else if (bSeqLength)
        {
            gb.setSeqLength(Integer.parseInt(data.toString()));
            bSeqLength = false;
        } else if (bDateCreate)
        {
            gb.setDateCreate(data.toString());
            bDateCreate = false;
        } else if (bTitle)
        {
            gb.setTitle(data.toString());
            bTitle = false;
        } else if (bAccession)
        {
            gb.setAccession(data.toString());
            bAccession = false;
        } else if (bSpecies) {
            gb.setSpecies(data.toString());
            bSpecies = false;
        } else if (bArticle_1 && gb.getPaper_1() == null)
        {
            gb.setPaper_1(data.toString());
            bArticle_1 = false;
        } else if (bArticle_1 && gb.getPaper_1() != null && gb.getPaper_2() == null)
        {
            gb.setPaper_2(data.toString());
            bArticle_1 = false;
        } else if (bArticle_1 && gb.getPaper_1() != null && gb.getPaper_2() != null && gb.getPaper_3() == null)
        {
            gb.setPaper_3(data.toString());
            bArticle_1 = false;

        } else if (bArticle_1 && gb.getPaper_1() != null && gb.getPaper_2() != null && gb.getPaper_3() != null && gb.getPaper_4() == null)
        {
            gb.setPaper_4(data.toString());
            bArticle_1 = false;
        } else if (bArticle_1 && gb.getPaper_1() != null && gb.getPaper_2() != null && gb.getPaper_3() != null && gb.getPaper_4() != null && gb.getPaper_5() == null)
        {
            gb.setPaper_5(data.toString());
            bArticle_1 = false;

        } else if (bDoi_1 && gb.getDoi_1() == null)
        {
            gb.setDoi_1(data.toString());
            bDoi_1 = false;
        } else if (bDoi_1 && gb.getDoi_1() != null && gb.getDoi_2() == null)
        {
            gb.setPaper_2(data.toString());
            bDoi_1 = false;
        } else if (bDoi_1 && gb.getDoi_1() != null && gb.getDoi_2() != null && gb.getDoi_3() == null)
        {
            gb.setPaper_3(data.toString());
            bDoi_1 = false;

        } else if (bDoi_1 && gb.getDoi_1() != null && gb.getDoi_2() != null && gb.getDoi_3() != null && gb.getDoi_4() == null)
        {
            gb.setPaper_4(data.toString());
            bDoi_1 = false;
        } else if (bDoi_1 && gb.getDoi_1() != null && gb.getDoi_2() != null && gb.getDoi_3() != null && gb.getDoi_4() != null && gb.getDoi_5() == null)
        {
            gb.setPaper_5(data.toString());
            bDoi_1 = false;
        } else if (bSequence)
        {
            gb.setSequence(data.toString());
            bSequence = false;
        } else if (bCountry_value)
        {
            gb.setCountry(data.toString());
            bCountry = false;
            bCountry_value = false;
        } else if (bIsolation_value)
        {
            gb.setIsolation(data.toString());
            bIsolation = false;
            bIsolation_value = false;
        } else if (bIsolate_value)
        {
            gb.setIsolate(data.toString());
            bIsolate = false;
            bIsolate_value = false;
        }
        if (qName.equalsIgnoreCase("INSDSeq"))
        {
            gbList.add(gb);
        }
    }


    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

}
