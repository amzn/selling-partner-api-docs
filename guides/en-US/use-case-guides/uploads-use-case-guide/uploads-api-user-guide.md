# Uploads API Use Case Guide 
API Version: 2020-09-01


# What is the Uploads API?

The Uploads API is a "helper" API that provides functionality that is required in the workflows of other Selling Partner APIs. The Uploads API lets you create a destination for uploading a file, and returns a destination identifier and authorization information that you can use for uploading the file. After uploading the file you can then programmatically access it using the destination identifier.

Here are the high-level steps for using the Upload API:

1. Call the [createUploadDestinationForResource](https://github.com/amzn/selling-partner-api-docs/blob/main/references/uploads-api/uploads_2020-11-01.md#createuploaddestinationforresource) to create a destination.

    Amazon returns a destination identifier and authorization information for uploading a file.

2. Upload your file, using the destination identifier and authorization information provided in the previous step.
3. Access the file with an API call that includes the destination identifier.

The following use case guides provide detailed implementation information for the Uploads API in the context of the workflows of other Selling Partner APIs:

- [A+ Content API Use Case Guide](https://github.com/amzn/selling-partner-api-docs/blob/main/guides/en-US/use-case-guides/aplus-content-api-use-case-guide/aplus-content-api-use-case-guide_2020-11-01.md)

