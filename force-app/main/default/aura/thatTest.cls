Here is an example of a Salesforce unit test for the given class:

@isTest
private class RetrieveLoanDetailsTest {
    @isTest
    static void testRetrieveLoanDetails() {
        // Create a new test loan record
        Loan__c testLoan = new Loan__c();
        testLoan.Name = 'Test Loan';
        testLoan.Email__c = 'test@email.com';
        insert testLoan;
        
        // Create a new test component and set the loanId attribute
        Test.startTest();
        RetrieveLoanDetailsController controller = new RetrieveLoanDetailsController();
        TestComponent testComponent = new TestComponent();
        testComponent.set("v.loanId", testLoan.Id);
        controller.retrieveLoanDetails(testComponent, null, null);
        Test.stopTest();
        
        // Verify that the loan details have been retrieved and set in the component
        System.assertEquals(testLoan.Email__c, testComponent.get("v.loanDetails.Email__c"));
    }
}

// Test utility class to simulate component and attribute methods
private class TestComponent {
    Map<String, Object> attributes = new Map<String, Object>();
    
    public Object get(String attributeName) {
        return attributes.get(attributeName);
    }
    
    public void set(String attributeName, Object attributeValue) {
        attributes.put(attributeName, attributeValue);
    }
}