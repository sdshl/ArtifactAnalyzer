package model;

import java.util.ArrayList;

import util.KeyValuePair;
import analyzer.ShotNumberJpegAnalyzer;

public class ShotNumberJpeg extends BaseModel
{
 public ShotNumberJpeg(String path)
 {
	super(path); 
 }
 /**
  * Analyzes the input file by first attempting to extract model-specific data from the file and
  * then trying to validate it by getting the match percent of the file to the model
  * Extraction and validation are carried out in the model's specific analyzer
  * 
  * @return percent match as a double value, -1.0 if there was an error or exception
  */
 public double analyzeFile(ArrayList<KeyValuePair> kTypeList)
 {
	 ShotNumberJpegAnalyzer shotNumAnalyze = new ShotNumberJpegAnalyzer(super.filePath);
	 super.keyValues = shotNumAnalyze.extractFile(kTypeList);
	 if (super.keyValues == null)
		 return -1.;
	 else
		 return shotNumAnalyze.validate();
 }
}
