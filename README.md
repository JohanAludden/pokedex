#Considerations
* I have done a skeleton application that connects to the required apis.
* I would have done more test cases and error handling in a real application.
* At the moment the configured bean, `RestTemplate` is in the application file, in a real application it should be moved
into a configuration file.
* I wanted to keep the controller as slim as possible and just forward the call to a service. I decided that its enough
 with one service, and the translated version uses the other to get the data and then calls the other api.
* In a real application I may have created a model representing the data I need from the external APIs and map them to
my domain model. If the parsing would be more complicated I would move that out from the service, I did not feel the
need for that with the code I wrote, but would be something I keep my eyes on, both from testing and complexity in the
production class.
* I created the interfaces around the remote api calls to create a natural place for extensions, and make the test
easier to write.
