package cucumberOptions;


	
	import org.junit.runner.RunWith;
	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;
	@RunWith(Cucumber.class)
	@CucumberOptions(
	   //path of feature file
	   features = {"C:\\work-stuff\\workspace\\OrangeHRM\\src\\test\\java\\com\\cucumber\\feature\\Login.feature"},
	   //path of step definition file
	   glue = "addproduct.stepDefinations"
	   )
	public class TestRunner {
		
	}


