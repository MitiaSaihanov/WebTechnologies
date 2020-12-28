import logo from './logo.svg';
import './App.css';
import React from 'react';
import ReactDOM from 'react-dom';
import Prod from './Prod';



function Contant(props) {
  return (

<div className="container wrapper">
  <div className="row">
    <main className="col-lg-12">
      <div className="row page-title page-title__header">
        <div className="col-md-8">
          <h2>Basket</h2></div>
      </div>
      <div className="row page-content content-grid" id="ContElement">
        <div className="row col-md-8">
          <div className="content-item col-md-12">
            <div className=" item-wrapper">
            {props.products.length ? (
              <div className="container-fluid ">
                 {props.products.map((product,index)=>{
                    return <Prod product={product}/>
                 })}
              </div>):(<div><p>Card clear</p></div>)}
            </div>
          </div>
        </div>
        <div className="row col-md-4">
          <div className="card-container item-wrapper">
            <h2>Сумма заказа</h2>
            <div className=" col-md-12 layer">Стоимость <span> </span>{props.sum()}$</div>
            <button className="cellbutton" id="Cell">Купить товар</button>
          </div>
        </div>
      </div>
    </main>
  </div>
</div>
  );
}

function TodoList({product,index}){
return
}
export default Contant;
