import {configureStore} from "@reduxjs/toolkit";

import themeReducer from './themeReducer'


const store = configureStore({
    reducer:{
        theme:themeReducer,
    }
})

export default store;