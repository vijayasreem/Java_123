
({
    retrieveLoanDetails: function(component, event, helper) {
        var loanId = component.get("v.loanId");
        
        // Call the server-side Apex controller to retrieve loan details
        var action = component.get("c.getLoanDetails");
        action.setParams({ loanId: loanId });
        
        action.setCallback(this, function(response) {
            var state = response.getState();
            if (state === "SUCCESS") {
                var loanDetails = response.getReturnValue();
                component.set("v.loanDetails", loanDetails);
            } else if (state === "ERROR") {
                var errors = response.getError();
                if (errors) {
                    var message = 'Unknown error';
                    if (errors[0] && errors[0].message) {
                        message = errors[0].message;
                    }
                    console.error('Error retrieving loan details: ' + message);
                } else {
                    console.error('Unknown error');
                }
            }
        });
        
        $A.enqueueAction(action);
    }
})
