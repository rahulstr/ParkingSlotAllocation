import {
  BrowserRouter as Router,
  Routes,
  Route,

} from 'react-router-dom';


import { ViewAllVehicle } from "./component/ViewAllVehicle";
import { ViewVehicleByVehicleNumber } from "./component/ViewVehicleByVehicleNumber";

import AddVehicle  from "./component/AddVehicle";
import UpdateVehicle from './component/UpdateVehicle';
import {DeleteVehicleByVehicleNumber} from "./component/DeleteVehicleByVehicleNumber";
import { GetVehicleById } from "./component/GetVehicleById";
import UpdateVehicleById from "./component/UpdateVehicleById";

function App(){
  return(
    <div>
        <Router>
        <Routes>
       
 
      
      <Route exact path="/addVehicle" element={<AddVehicle/>}/>
      <Route exact path="/viewAllVehicle"element={<ViewAllVehicle/>}/>
      <Route exact path="/viewVehicleByVehicleNumber"element={<ViewVehicleByVehicleNumber/>}/>
      
     
      <Route exact path="/deleteVehicleByVehicleNumber" element={<DeleteVehicleByVehicleNumber/>}/>
      <Route exact path="/updateVehicle/:id" element={<UpdateVehicle/>}/>
      <Route exact path="/viewvehiclebyid" element={<GetVehicleById/>}/>
      <Route exact path="/updateVehiclebyid" element={<UpdateVehicleById/>}/>
      </Routes>
      </Router> 
    </div>
  );
}

export default App;