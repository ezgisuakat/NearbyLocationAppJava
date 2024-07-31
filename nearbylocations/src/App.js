import React, { useState } from 'react';
import axios from 'axios';
import './App.css';

const App = () => {
  
  const [latitude, setLatitude] = useState('');
  const [longitude, setLongitude] = useState('');
  const [radius, setRadius] = useState('');
  const [places, setPlaces] = useState([]);

  const apiKey = 'xxxxx'; 

  const fetchPlaces = async () => {
    
    const response = await axios.get('http://localhost:8070/api/place/nearbysearch', {
      params: {
        latitude: latitude,
        longitude: longitude,
        radius: radius,      
      }

    });
    setPlaces(response.data.placeInfoLocationDTOs);
  };

  return (
    <div className="min-h-screen bg-gray-100 flex flex-col items-center p-4">
      <h1 className="text-3xl font-bold mb-4">NEARBY LOCATIONS APPLICATION</h1>
      <div className="mb-4">
        <input
          type="text"
          placeholder="Latitude"
          value={latitude}
          onChange={(e) => setLatitude(e.target.value)}
          className="p-2 border border-gray-300 rounded mr-2"
        />
        <input
          type="text"
          placeholder="Longitude"
          value={longitude}
          onChange={(e) => setLongitude(e.target.value)}
          className="p-2 border border-gray-300 rounded mr-2"
        />
        <input
          type="text"
          placeholder="Radius (meters)"
          value={radius}
          onChange={(e) => setRadius(e.target.value)}
          className="p-2 border border-gray-300 rounded mr-2"
        />
        <button onClick={fetchPlaces} className="p-2 bg-blue-500 text-white rounded">
          Ara
        </button>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {places.map((place) => (
          <div key={place.place_id} className="bg-white p-4 rounded shadow">
            <img
              src={`https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=${place.photos?.[0].photo_reference}&key=${apiKey}`}
              alt={place.name}
              className="w-full h-48 object-cover rounded mb-4"
            />
            <h2 className="text-2xl font-bold mb-2">{place.name}</h2>
            <p className="text-gray-700 mb-2">{place.vicinity}</p>
            <p className="text-gray-700">Rating: {place.rating} ({place.user_ratings_total} reviews)</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default App;

