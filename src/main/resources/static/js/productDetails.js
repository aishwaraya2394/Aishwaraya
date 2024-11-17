const params = new URLSearchParams(window.location.search);
const id =params.get('id');

async function getProductDetails(){

    try{
        const response = await fetch(`/products/${id}`);

        if(!response.ok){
            throw new Error(`Error: ${response.status}`);
        }

        const product = await response.json();

        const productDetails = document.getElementById('productDetails');
        productDetails.innerHTML = `
            <p><strong>Name:</strong>${product.name}</p>
            <p><strong>Category:</strong>${product.category}</p>
            <p><strong>Description:</strong>${product.description}</p>
            <p><strong>Price:</strong>${product.price}</p>
            <p><img src ="/images/${product.id}.jpeg"
                    style="max-width:300px; max-height:300px"></p>
        `;
    }
    catch(error){

        console.error('Error fetching Product details:', error);
    }
}

async function addNewProduct(){
    const name = document.getElementById('name').value;
    const category = document.getElementById('category').value;
    const description = document.getElementById('description').value;
    const price = document.getElementById('price').value;
    const imageUrl = document.getElementById('imageUrl').value;

    try{
        const response = await fetch(`/products`, {
                method:'POST',
                headers: {'Content-type' : 'application/json'},
                body: JSON.stringify ({name,category,description,price,imageUrl})
            });

            const message = await response.text();

            document.getElementById('message').textContent = message;
            if (response.ok) {
                window.location.assign("/search.html");
            } else {
                console.error(`Error adding product: ${message}`);
            }
    }
    catch(error){
        console.error('An error occured while adding the product:', error);

    }




}