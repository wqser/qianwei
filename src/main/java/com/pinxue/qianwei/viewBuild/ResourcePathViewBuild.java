package com.pinxue.qianwei.viewBuild;

import com.pinxue.qianwei.model.ResourcePath;
import org.springframework.stereotype.Component;

@Component
public class ResourcePathViewBuild implements ViewBuilder<ResourcePath,ResourcePathView> {
    @Override
    public ResourcePathView build(ResourcePath resourcePath) {
        ResourcePathView view = new ResourcePathView();
        view.setP1(resourcePath.getP1());
        view.setP2(resourcePath.getP2());
        view.setP3(resourcePath.getP3());
        view.setImgSrc(resourcePath.getImgSrc());
        return view;
    }
}
