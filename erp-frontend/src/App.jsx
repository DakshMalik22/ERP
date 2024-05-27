import React from 'react'
import { Provider } from 'react-redux'
import {BrowserRouter,Routes,Route} from 'react-router-dom';
import store from './store/store'; 
import Landing from './pages/Landing';
import HrmLogin from './pages/HrmLogin';
import EmsLogin from './pages/EmsLogin';
import CrmLogin from './pages/CrmLogin';
import EmsDashboard from './pages/EmsDashboard'
import EmsAdminDashboard from './pages/EmsAdminDashboard';
import EmsCreateTask from './pages/EmsCreateTask';
import EmsAdminProjects from './pages/EmsAdminProjects';
import EmsEmployeeList from './pages/EmsEmployeeList';
import EmsCreateEmployee from './pages/EmsCreateEmployee';
import EmsCreateAdmin from './pages/EmsCreateAdmin';
import EmsEmpLeaves from './pages/EmsEmpLeaves';
import EmsEmpLeaveStatus from './pages/EmsEmpLeaveStatus';
import EmsEmpProfile from './pages/EmsEmpProfile';

const App = () => {
  return (
    <BrowserRouter>
      <Provider store={store}>
      <Routes>
        <Route path='/' element={<Landing />}></Route>
        <Route path='/hrmLogin' element={<HrmLogin />}></Route>
        <Route path='/crmLogin' element={<CrmLogin />}></Route>
        <Route path='/emsLogin' element={<EmsLogin />}></Route>
        <Route path='/emsDashboard' element={<EmsDashboard />}></Route>
        <Route path='/emsAdminDashboard' element={<EmsAdminDashboard />}></Route>
        <Route path='/createTask' element={<EmsCreateTask />}></Route>
        <Route path='/emsProjects' element={<EmsAdminProjects />}></Route>
        <Route path='/emsEmployeeList' element={<EmsEmployeeList />}></Route>
        <Route path='/emsCreateEmployee' element={<EmsCreateEmployee />}></Route>
        <Route path='/emsCreateAdmin' element={<EmsCreateAdmin />}></Route>
        <Route path='/emsApplyLeaves' element={<EmsEmpLeaves />}></Route>
        <Route path='/emsLeaveStatus' element={<EmsEmpLeaveStatus />}></Route>
        <Route path='/emsProfile' element={<EmsEmpProfile />}></Route>
     </Routes>
    </Provider> 
    </BrowserRouter>
  )
}

export default App