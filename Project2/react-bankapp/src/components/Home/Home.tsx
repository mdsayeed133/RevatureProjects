import '../Home/Home.css'

import React from 'react'
import Header from '../Header/Header'

import { FaAws, FaReact } from "react-icons/fa";
import { SiTypescript, SiSpring, SiPostgresql, SiBootstrap, SiPython } from "react-icons/si";
import { Link, useNavigate } from 'react-router-dom';

const Home: React.FC<any> = (props: any) => {
    // get the state
    const navigate = useNavigate();
    // create useState hooks to declare the states
    // const [username, setUsername] = useState("");


    /* worry about home page look */
    const login = async () => {
        navigate("/login")
    }
    const signup = async () => {
        navigate("/signup")
    }

    
    const status = props.loggedStatus;
    console.log(status);


    React.useEffect(()=>{ 
        if(status != true){
            console.log('not logged in')
        } else {
            const element: HTMLElement = document.getElementById('stat') as HTMLElement 
            element.innerHTML = `You are logged in ${props.targetUser.firstName}`
        }
    })
    // if (status != true) {
    //     console.log('nothing');
    // } else {
        // document.body.classList.add("dark")
        // document.getElementById("loginBox")?.id="d-none";
        // document.getElementById("accountBox")?.id="d-none";
        // let stat = document.getElementById("stat")
        // document.getElementById("loginBox").classList.add("d-block")
    //}

    return (
        <div>
            <Header targetUser={props.targetUser}/>
            <div className="check-log-status">
                <p id="stat"></p>
            </div>
            <section className="d-none d-md-block carousel-section">
                <div id="carouselExampleFade" className="carousel slide carousel-fade">
                    <div className="carousel-inner">
                        <div className="carousel-item active">
                            <img src="stress1.jpg" className="d-block w-100 img-fluid" alt="Someone who isn't using Revature Banking" />
                        </div>
                        <div className="carousel-item">
                            <img src="stress2.jpg" className="d-block w-100 img-fluid" alt="Image of a woman not using" />
                        </div>
                        <div className="carousel-item">
                            <img src="money.jpg" className="d-block w-100 img-fluid" alt="..." />
                        </div>
                    </div>
                    <button className="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
                        <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span className="visually-hidden">Previous</span>
                    </button>
                    <button className="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
                        <span className="carousel-control-next-icon" aria-hidden="true"></span>
                        <span className="visually-hidden">Next</span>
                    </button>
                </div>
            </section>
            <div className="main-container container">
                <div className="row dividing-line d-flex justify-content-around">
                    <div className="col-md-6 login-options d-none d-md-block" id="loginBox">
                    <section>
                    <h3 className="subheader">Not Logged In?</h3>
                    <p className="text d-none d-md-block">If you want to make the most of the opportunities that Revature Banking can provide you, please click to login</p>
                    {/* <Link to="/login" className="log-btn btn btn-secondary">Login</Link> */}
                <button className="log-btn btn btn-secondary" onClick={login}>Login</button>
            </section>
        </div>
        <div className="col-md-6 login-options" id="accountBox">
            <section>
                <h3 className="subheader">No Account?</h3>
                <p className="text d-none d-md-block">If you want to make the most of the opportunities that Revature Banking can provide you, please click to create an account</p>
                {/* <Link to="/Signup" className="log-btn btn btn-secondary">Create Account</Link> */}
                <button className="log-btn btn btn-secondary" onClick={signup}>Create Account</button>
            </section>
        </div>
                </div>
                <div className="row dividing-line">
                    <h2 className="why-container">Why Choose RevatureBanking?</h2>
                    <p>Revature is the world's leading talent enablement firm and employer of tech professionals.</p>
                </div>
                <div className="d-none d-md-block banner-container container-fluid dividing-line">
                    <h1>Work with us while we work for you!</h1>
                    <img src="pexels-fauxels-3184632.jpg" alt="company unit NOT family" className="img-fluid teampic" />
                </div>
                <div className="row dividing-line">
                    <div className="col-4 sub-info">
                        <h3>info here</h3>
                        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Architecto laudantium cum recusandae debitis ipsam aperiam labore pariatur exercitationem quasi. Molestias dolores modi ullam officiis corrupti tenetur mollitia a! Id inventore animi, veritatis harum illo soluta hic? Tenetur corrupti porro voluptatibus.</p>
                    </div>
                    <div className="col-4 sub-info">
                        <h3>info here</h3>
                        <p>Deleniti minus at cumque dolore placeat quod amet, praesentium eveniet vitae voluptates, fugiat nam quaerat temporibus maiores et sed natus totam aperiam, tenetur accusamus nemo? Dolor expedita error est, totam vero earum corrupti mollitia similique facilis neque? Labore, veritatis nemo.</p>
                    </div>
                    <div className="col-4 sub-info">
                        <h3>info here</h3>
                        <p>Ut, adipisci maxime repudiandae dolorem doloribus quibusdam animi ipsam dolor. Voluptas quo, maiores error, ab laboriosam nobis voluptatum voluptate in commodi odit, rerum necessitatibus ducimus amet alias! Aperiam cupiditate libero accusantium? Libero quaerat cupiditate explicabo vero deserunt, ex dolorem autem!</p>
                    </div>
                </div>
            </div>
            <div className="container main-tech-stack">
                <h3>Created With:</h3>
                <div className="icon-list d-flex justify-content-around">
                    <SiBootstrap size="5em" className="icons" />
                    <FaAws size="5em" className="icons" />
                    <FaReact size="5em" className="icons" />
                    <SiSpring size="5em" className="icons" />
                    <SiTypescript size="5em" className="icons" />
                    <SiPostgresql size="5em" className="icons" />
                    <SiPython size="5em" className="icons" />
                </div>
            </div>
        </div>
    )
}

export default Home
