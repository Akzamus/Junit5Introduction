package org.example.JUnit5.Tag;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectPackages("org.example.JUnit5")
@IncludeTags({"development","production"})
public class TestSuites { }

@RunWith(JUnitPlatform.class)
@SelectPackages("org.example.JUnit5")
@IncludeTags("production")
class ProductionTestSuit{}

@RunWith(JUnitPlatform.class)
@SelectPackages("org.example.JUnit5")
@IncludeTags("development")
class DevelopmentTestSuit{}


