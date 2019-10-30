import React from react;

export default function Products() {
    let [products, setProducts] = useState([
      {
        name: 'Nøgne Ø Imperial Stout',
      },{
      name: 'Nøgne Ø Imperial Stout',
      },
      {
        name: 'Nøgne Ø Imperial Stout',
        },
    ]);
  
    

    let handleDeleteTodo = indexToDelete => {
      // Handle delete products from state here
      const newArray = products.filter((element, index) => index !== indexToDelete);
  
      setProducts(newArray);
    };
  
    let handleAddProduct = product => {
      // Handle add products here.
    };
  
    return (
      <div className="Todos">
        <h2>Todos</h2>
        <Todos todo={todo} handleDeleteTodo={handleDelete} />
      </div>
    );
  }
  