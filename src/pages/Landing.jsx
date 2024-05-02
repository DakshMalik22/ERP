import React from 'react'
import Modules from '../components/Modules';
import Footer from '../components/Footer';
import Features from '../components/Features';
import Navbar from '../components/Navbar'
import Hero from '../components/Hero'

const Landing = () => {
  return (
    <div className='h-[100%] w-[100%]'>
      <Navbar/>
      <Hero/>
      <Modules/>
      <Features/> 
      <Footer/> 
    </div>
  )
}

export default Landing