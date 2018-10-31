package FileReader.service;

import enums.MimeType;
import pojo.FileDetails;
import pojo.VehicleDetails;
import service.FileReaderService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class FileReaderServiceImplTest {

	private FileReaderService fileReaderService;
	
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testEmptyDirectory() throws Exception {
        List<FileDetails> fileDetailsList = fileReaderService.getFileContents(folder.getRoot().getPath());
        assertEquals(0, fileDetailsList.size());
    }

    @Test
    public void testMimeTypeCSV () throws Exception {
        List<FileDetails> fileDetailsList = fileReaderService.getFileContents(folder.getRoot().getPath());
        FileDetails fileDetails = fileReaderService.getFileDetailsFromFile("testfile1.csv");
        assertEquals(MimeType.CSV,fileDetails.getMimeType());
    }

    @Test
    public void testMimeTypeTxt () throws Exception {
        List<FileDetails> fileDetailsList = fileReaderService.getFileContents(folder.getRoot().getPath());
        assertNull(fileReaderService.getFileDetailsFromFile("testfile2.csv"));
    }

    @Test
    public void testMimeTypeExcel() throws Exception {
        List<FileDetails> fileDetailsList = fileReaderService.getFileContents(folder.getRoot().getPath());
        FileDetails fileDetails = fileReaderService.getFileDetailsFromFile("testfile5.xls");
    }


    @Test
    public void testVehicleDetailsAddedCSV() throws Exception {
        List<FileDetails> fileDetailsList = fileReaderService.getFileContents(folder.getRoot().getPath());
        VehicleDetails vehicleDetails = fileReaderService.getVehicleDetailsFromFile("testfile3.csv");
    }

    @Test
    public void testVehicleDetailsAddedXLS() throws Exception {
        List<FileDetails> fileDetailsList = fileReaderService.getFileContents(folder.getRoot().getPath());
        VehicleDetails vehicleDetails = fileReaderService.getVehicleDetailsFromFile("testfile5.xls");
    }





}
