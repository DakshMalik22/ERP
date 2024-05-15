export const setMode = (newMode) => ({
  type: 'SET_MODE',
  payload: newMode
});

const initialState = {
  mode: 'light'
};

const themeReducer = (state = initialState, action) => {
  switch (action.type) {
    case 'SET_MODE':
      return {
        ...state,
        mode: action.payload
      };
    default:
      return state;
  }
};

export default themeReducer;
