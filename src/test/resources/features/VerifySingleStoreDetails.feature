Feature: Get stores details

Background:
Given "stores" api is invoked with limit 1
Then 200 response code is returned
And Store id is retrieved
And store the details of store in context

Scenario: Get Specific store details using store id
Given "stores" api is invoked for a single store
Then 200 response code is returned
And details of store are verified
