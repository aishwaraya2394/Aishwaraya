let currentPage = 0;
const pageSize =2;
console.log('entered getAllProducts')


async function getAllProducts(){
console.log('entered getAllProducts')
    try{
        const response = await fetch(`/products`);
        console.log('sent request for fetching all Products')

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


async function searchProduct(name = ' '){

    if(name === ''){
        currentPage = 0;
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

