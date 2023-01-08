import '../Home/Home.css'

import React from 'react'
import Header from '../Header/Header'

import { FaAws, FaReact } from "react-icons/fa";
import {SiTypescript, SiSpring, SiPostgresql, SiBootstrap} from "react-icons/si";

const Home: React.FC<any> = () => {


    /* worry about home page look */
    return (
        <div>
            <Header />
            <div className="main-container container">
                <div className="banner-container">
                    <h1>Big Banner Goes Here</h1>
                    <p>Something something motivational and empty</p>
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
                <h3>Simple React Icons</h3>
                <div className="icon-list">
                    <SiBootstrap size="5em"/>
                    <FaAws size="5em"/>
                    <FaReact size="5em"/>
                    <SiSpring size="5em"/>
                    <SiTypescript size="5em"/>
                    <SiPostgresql size="5em"/>
                </div>
            </div>
        </div>
    )
}

export default Home