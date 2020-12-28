import './App.css';
import React,{useContext} from 'react';
import ReactDOM from 'react-dom';
import Context from './Context'

function Prod({product}) {
    const {removeProds}=useContext(Context)
  return (

   <div className="row">
     <div className="item-image col-md-4">
       <img className="blocktext" src={product.linc} alt=""></img>
     </div>
     <div className=" col-md-8 padding-tb">
       <h4 className="title" />
       <div className="item-characteristics">
         Производитель: <span>{product.Manufacturer}</span>
       </div>
       <div className="item-characteristics">
         Город: <span>{product.City}</span>
       </div>
       <div className="item-characteristics">
         Цвет: <span>{product.Color}</span>
       </div>
     </div>
     <div className="item-actions row">
       <div className="item-price col-md-8">
         <span className="span"></span>{product.Price}$</div>
       <div className="col-md-4">
         <button className=" deletbutton" onClick={()=>removeProds(product.id)}>Удалить</button>
       </div>
     </div>
   </div>
   );
}

   export default Prod;