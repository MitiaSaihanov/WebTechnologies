import logo from './logo.svg';
import './App.css';
import React , { useEffect }from 'react';
import ReactDOM from 'react-dom';
import Contant from './Contant'
import Context from './Context';

function App() {
      const [prods,setProds] = React.useState([
          {id: 1, linc: "https://imageup.ru/img230/3677202/98eb939933fe407407248f3bb6a5d4a8f5c08edb49d4925d80ee121fd60982eb.jpg", Price: 15, City: "Moscov",Manufacturer: "Apple",Manufacturer1:"Moel10",Color:"black"},
          {id: 2, linc: "https://imageup.ru/img230/3677202/98eb939933fe407407248f3bb6a5d4a8f5c08edb49d4925d80ee121fd60982eb.jpg", Price: 25, City: "Moscov",Manufacturer: "Apple",Manufacturer1:"Moel10",Color:"black"},
          {id: 3, linc: "https://imageup.ru/img230/3677202/98eb939933fe407407248f3bb6a5d4a8f5c08edb49d4925d80ee121fd60982eb.jpg", Price: 35, City: "Moscov",Manufacturer: "Apple",Manufacturer1:"Moel10",Color:"black"},
          {id: 4, linc: "https://imageup.ru/img230/3677202/98eb939933fe407407248f3bb6a5d4a8f5c08edb49d4925d80ee121fd60982eb.jpg", Price: 45, City: "Moscov",Manufacturer: "Apple",Manufacturer1:"Moel10",Color:"black"},
          {id: 5, linc: "https://imageup.ru/img230/3677202/98eb939933fe407407248f3bb6a5d4a8f5c08edb49d4925d80ee121fd60982eb.jpg", Price: 55, City: "Moscov",Manufacturer: "Apple",Manufacturer1:"Moel10",Color:"black"},
          {id: 6, linc: "https://imageup.ru/img230/3677202/98eb939933fe407407248f3bb6a5d4a8f5c08edb49d4925d80ee121fd60982eb.jpg", Price: 65, City: "Moscov",Manufacturer: "Apple",Manufacturer1:"Moel10",Color:"black"}
      ])

  function removeProds(id){
      setProds(prods.filter(prod=>prod.id!==id))
  }
  function getSum(){
  var sum=0;
  for(var i=0;i<prods.length;i++){
      sum = sum + parseInt(prods[i].Price);
  console.log(sum);
  }
  return sum;
  }
  return (
    <Context.Provider value={{removeProds}}>
    <header className="page-header">
        <div className="page-header-cook">
            <div className="container"><span id="myBtn">Moscov</span></div>
        </div>
        <div className="page-header__navbar">
            <div className="container">
                <nav className="navbar navbar-expand-lg navbar-light">
                    <a className="navbar-brand" href="#">
                    </a>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item active">
                                <a className="nav-link" href="/home-with-session">Home</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">
                                    Products
                                </a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Payment</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Shopping</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </header>
    <Contant products={prods} sum={getSum}/>
    </Context.Provider>
  );
}

export default App;
