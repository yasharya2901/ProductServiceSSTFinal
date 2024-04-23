<details> <summary>Date</summary>16th April 2024 </details>

# Unit Testing

## Properties of Unit Test Cases
- Fast
- Isolated
- Mocked

## Best Practices
### 3 A's for Unit Testing
- Arrange - Create the input for the test
- Act - Execute the code being tested
- Assert - Check the output against the expected result

```Java
testAddition() {
    int a = 10; // Arrange
    int b = 5; // Arrange
    Calculator c = new Calculator(); // Arrange
    
    int result = c.add(a, b); // Act
    
    if (result != 15) { // Assert
        throw new Exception("Test failed");
    }
}
```

###  Isolation
- Unit tests should be isolated from each other
- Each test should be independent of the others

### Repeatable
- Tests should be repeatable
- Running the same test multiple times should produce the same result
- Tests cases should not be flaky

### Self-Checking
- Tests should be self-checking
- The test should be able to determine if it passed or failed without human intervention

### Test the behavior, not the implementation
- Tests should be written to test the behavior of the code, not the implementation
- This allows the implementation to change without breaking the tests
- We only care about the final output expected from the code
- Implementations can change, but the behavior should remain the same
- This is known as black-box testing
- White-box testing is when you test the implementation


## Mocking
Mocking is a technique used in unit testing to replace a real object with a fake object.

We should focus on the code/business logic written within that method, we don't want our test case to get affected because of any external dependencies.

We typically mock the external dependencies while writing our test cases.

```PsudeoCode
test() {
    ---
    ---
    ---
    when(productService.getProductById(10L)) {
        thenReturn(new Product());
    }
}
```
The above code says that when we need product with id 10 from productService, then instead of calling the service return the hard coded data.

### Test Doubles
When we mock the dependencies, we create Test Doubles.

Test Doubles are objects that are used in place of the real object in the test cases.
#### Types of Test Doubles
1. Mock - A mock object is a fake object that is used to test the behavior of some other object.
    ```
    when(productService.getProductById(10L)) {
        thenReturn(new Product());
    }
    ```
   
    Scenario:
    - Create 5 products
    - get the count of products
    - create 1 product
    - get the count of products

    Since mock is the hard coded data, the count of products will be 5 and not 6.
    To solve this, we use a stub.


2. Stub - A stub is a fake object that is used to provide a response to a method call.
    ```Java
    class ProductRepositoryStub{
        int count = 0;
        createProduct(){
            count++;
        }
        getCount(){
            return count;
        }
   }
    ```
   
    For the above scenario, we write the following test:
    ```PsudeoCode
    test() {
        ProductRepositoryStub prs = new ProductRepositoryStub();
        
        prs.createProduct();
        prs.createProduct();
        prs.createProduct();
        prs.createProduct();
        prs.createProduct();
        
        int count = prs.getCount(); // 5
        
        prs.createProduct();
        count = prs.getCount(); // 6
    }
   ```
   
3. Fake - A fake object is a simplified version of the real object that is used in the test cases.
    ```Java
        class ProductRepositoryFake{
            HashMap<Long, Product> map = new HashMap<>();
            int id = 0;
            
            createProduct(){
                Product p = new Product();
                p.setId(++id);
                map.put(id, p);
            }
            getCount(){
                return map.size();
            }
        }
    ```
    Here, we are using a HashMap to store the products. This is a fake object of the Database.


<table>
    <thead>
        <tr>
            <th>Mock</th>
            <th>Stub</th>
            <th>Fake</th>
        </tr>
    </thead>
    <tbody>
        <tr colspan="3"> 
            <td>----------------> Reality Increases</td>
        </tr>
        <tr colspan="3">
            <td>Hardcoding Increase <--------------</td>
        </tr>
    </tbody>
</table>
