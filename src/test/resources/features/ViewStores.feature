Feature:ViewStores

Scenario: View list of stores
Given "stores" api is invoked
Then 200 response code is returned
And verify the schema with "ViewStoresSchema.json"

#Scenario: View list of stores with incorrect schema
#Given "stores" api is invoked
#Then 200 response code is returned#
#And verify the schema with "IncorrectSchema.json"

