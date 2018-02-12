set projectLocation=C:\Users\Sachin\Cucumber\finsys
cd %projectLocation%
mvn clean test -Dcucumber.options="src/test/resources/FeatureCollections/CreateNewCompany.feature"
