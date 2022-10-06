package com.example.noithat.ui.constract;

import com.example.noithat.data.dao.model.Favourite;

import java.util.List;

public interface FavouriteFragmentConstract {
    interface IView{
        void setFavouriteListToView(List<Favourite> favouriteList);
    }

    interface IPresenter{
        void setView(IView view);
        void getFavouriteList();
    }
}
