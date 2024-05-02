import React from 'react'
import { Provider } from 'react-redux'
import {BrowserRouter,Routes,Route} from 'react-router-dom';
import store from './store/store'; 
import Landing from './pages/Landing';
import HrmLogin from './pages/HrmLogin';
import EmsLogin from './pages/EmsLogin';
import CrmLogin from './pages/CrmLogin';

const App = () => {
  return (
    <BrowserRouter>
      <Provider store={store}>
      <Routes>
        <Route path='/' element={<Landing />}></Route>
        <Route path='/hrmLogin' element={<HrmLogin />}></Route>
        <Route path='/crmLogin' element={<CrmLogin />}></Route>
        <Route path='/emsLogin' element={<EmsLogin />}></Route>
     </Routes>
    </Provider> 
    </BrowserRouter>
 
  )
}

export default App