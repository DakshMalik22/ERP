import React from 'react'
import Navbar from './components/Navbar'
import Hero from './components/Hero'
import { Provider } from 'react-redux'
import store from './store/store'; 
import Modules from './components/Modules';
import Footer from './components/Footer';
import Features from './components/Features';


const App = () => {
  return (
    <Provider store={store}>
      <div className='h-[100%] w-[100%]'>
      <Navbar/>
      <Hero/>
      <Modules/>
      <Features/>
      <Footer/>
      </div>
    </Provider> 
  )
}

export default App