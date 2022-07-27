import React from 'react'
import { Link } from 'react-router-dom'
const navbar = {
  margin: "0px",


}
export default function Menu1() {
  return (
    <div>
      <nav style={navbar} class="navbar navbar-expand-lg navbar-Dark bg-dark">
        <div class="container-fluid">
          <a class="navbar-brand" href="/">Parking Slot Application</a>
          <button class="navbar-toggler" style={{color:"white"}} type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav ">
              <li class="nav-item">
                <Link class="nav-link active" aria-current="page" to="">Home</Link>
              </li>
              <li class="nav-item">
                <Link class="nav-link active" aria-current="page" to="/user">User Registration</Link>
              </li>

              <li class="nav-item">
                <Link class="nav-link active" aria-current="page" to="/admin">Admin Registration</Link>
              </li>
              <li class="nav-item">
                <Link class="nav-link" to="/login1">Admin Login</Link>
              </li>


              <li class="nav-item">
                <Link class="nav-link" to="/login">User Login</Link>
                {/* <Link class="nav-link" to="/login1">Login1</Link> */}
              </li>

            </ul>

          </div>

        </div>
      </nav>

    </div>
  )
}