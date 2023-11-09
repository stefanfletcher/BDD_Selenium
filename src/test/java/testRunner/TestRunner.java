package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions (
       // features= {".//Features//"},
        //features= {".//Features//"Login.feature},
       // features= {".//Features//FailedLoginDDT.feature"},
         features= {".//Features//LoginDDTExcel.feature"},
        glue="stepDefinitions",
        plugin= {
                "pretty",
                "html:reports/myreport.html",
                "json:reports/myreport.json"
        },
       // dryRun=false,
        monochrome=true,
         tags = "@Regression"	//Scenarios tagged with @sanity,
      //  tags = "@Regression and Sanity"	//Scenarios tagged with @sanity,
      //  tags = "@Regression or Sanity"
)


public class TestRunner {
}
