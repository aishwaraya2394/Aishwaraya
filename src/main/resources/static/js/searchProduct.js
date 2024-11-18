async function getAllProducts(){
    try{
        const response = await fetch(`/products`);

        if(!response.ok){

            throw new Error(`Error: $(response.status)`);
        }
        const products = await response.json();

        displayProducts(products);

    }
    catch(error){

        console.error('Error fetching items',error);
    }

}


function displayProducts(productsToDisplay){

    const tableBody = document.getElementById('productsTable');
    tableBody.innerHTML = '';

    productsToDisplay.forEach(product => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${product.id}</td>
            <td><a href = "/products.html?id=${product.id}">${product.name}</td>
            <td>${product.category}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            `;
        tableBody.appendChild(row);
    });
}


async function searchProduct(name = ''){

    if(name === ''){
        getAllProducts();
        return;
    }
    try{
        const responseByName = await fetch(`/search?name=${name}`);

        if(!responseByName.ok){

            throw new Error(`Error: $(responseByName.status)`);
        }
        const productsByName = await responseByName.json();

        displayProducts(productsByName);

    }
    catch(error){
        console.error('Error fetching product:',error);
    }
}



document.getElementById('searchBar').addEventListener('input', function (){
    const name1 = this.value.trim();
    searchProduct(name1);
});


async function addNewProduct(){
    const name = document.getElementById('name').value;
    const category = document.getElementById('category').value;
    const description = document.getElementById('description').value;
    const price = parseFloat(document.getElementById('price').value);
    const imageUrl = document.getElementById('imageUrl').value;

    try{
        const response = await fetch(`/products`, {
                method:'POST',
                headers: {'Content-type' : 'application/json'},
                body: JSON.stringify ({name,category,description,price,imageUrl})
            });

            const message = await response.json();

            document.getElementById('message').textContent = message;
    }
    catch(error){
        console.error('An error occurred while adding the product:', error);

    }
}
