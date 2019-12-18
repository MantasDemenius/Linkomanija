import React from 'react';
import { Map, InfoWindow, Marker, GoogleApiWrapper } from 'google-maps-react';
import './map.css';

const MapContainer = (props) => {
    const style = {
        width: '100%',
        height: '300px',
    }
    return (
        <div style={style} id="mapBox">
            <Map google={props.google} zoom={6} initialCenter={{
                lat: 54.898521,
                lng: 23.903597
            }}>
                <Marker
                    title={'Kauno Akropolis "Linkomanija"'}
                    name={'Kauno Akropolis "Linkomanija"'}
                    position={{ lat: 54.8920730, lng: 23.9191431 }} />
                <Marker
                    title={'Vilniaus Akropolis "Linkomanija"'}
                    name={'Vilniaus Akropolis "Linkomanija"'}
                    position={{ lat: 54.7104961, lng: 25.2619950 }} />
                <Marker
                    title={'Šiaulių Akropolis "Linkomanija"'}
                    name={'Šiaulių Akropolis "Linkomanija"'}
                    position={{ lat: 55.9080246, lng: 23.2614028 }} />
                <Marker
                    title={'Klaipėdos Akropolis "Linkomanija"'}
                    name={'Klaipėdos Akropolis "Linkomanija"'}
                    position={{ lat: 55.6933324, lng: 21.1569152 }} />
            </Map>
        </div>
    );
};

export default GoogleApiWrapper({
    apiKey: 'AIzaSyAB02a4-Ck5KylPIVozcHJ63C-d7DmtCto'
})(MapContainer)
