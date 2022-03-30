package com.automationpractice.feature.feature;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/com/automationpractice/feature"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = { "pretty", "html:target/cucumber-reports" },
        monochrome = true)

public class RunMavenTest  {
}
