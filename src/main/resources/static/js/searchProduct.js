let currentPage = 0;
const pageSize =2;

async function getAllProducts(){

    try{
        const response = await fetch(`/products`);
        if(!response.ok){

            throw new Error(`Error: $(response.status)`);
        }
        products = await response.json();

        displayProducts(products);

        document.byElementId('prevPage').addEventListener('click', () => {

            if(currentPage > 0){
                currentPage--;
                getAllProducts();
            }

        });

        document.byElementId('nextPage').addEventListener('click', () => {

            currentPage++;
            getAllProducts();

        });

    }
    catch(error){

        console.error('Error fetching items',error);
    }

}

function displayProducts(products){

    const tableBody = document.byElementId('productsTable');
    tableBody.innerHTML = '';

    products.forEach(product => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${product.id}</td>
            <td><a href = "/products.html?id=${product.id}">${product.name}</td>
            <td>${product.category}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.imageUrl}</td>
            `;
        tableBody.appendChild(row);
    });
}




async function searchProduct(name = ' '){
    try{
        const responseByName = await fetch(`/search?name=${name}`);
        if(!response.ok){

            throw new Error(`Error: $(response.status)`);
        }
        productsByName = await responseByName.json();

        displayProducts(productsByName);

        document.byElementId('prevPage').addEventListener('click', () => {

            if(currentPage > 0){
                currentPage--;
                searchProduct();
            }

        });

        document.byElementId('nextPage').addEventListener('click', () => {

            currentPage++;
            searchProduct();

        });
    }
    catch(error){
        console.error('Error fetching product:',error);
    }
}

document.byElementId('searchBar').addEventListener('input', function ()  {
    const name = this.value;
    searchProduct(name);
});


