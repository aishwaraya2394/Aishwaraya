const params = new URLSearchParams(windows.location.search);
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
            <p><strong>Name:</strong>$<product.name></p>
            <p><strong>Category:</strong>$<product.name></p>
            <p><strong>Description:</strong>$<product.name></p>
            <p><strong>Price:</strong>$<product.name></p>
            <p><strong>ImageUrl:</strong><img src ="/img/${product.id}.jpeg"
                    style="max-width:300px; max-height:300px"></p>
        `;
    }
    catch(Error e){
        console.error('Error fetching Product details:', error);
    }
}